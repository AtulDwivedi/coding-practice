package com.atuldwivedi.codingpractice.java.multithreading;

/**
 * @author Atul Dwivedi
 */
public class ProducerConsumer03 {
    public static void main(String[] args) throws InterruptedException {

        final BlockingQueueWithSemaphore<Integer> bq = new BlockingQueueWithSemaphore<Integer>(5);

        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++) {
                    bq.enqueue(new Integer(i));
                    System.out.println("enqueued " + i);
                }
            } catch (InterruptedException ie) {

            }
        });

        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread 2 dequeued: " + bq.dequeue());
                }
            } catch (InterruptedException ie) {

            }
        });

        Thread t3 = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread 3 dequeued: " + bq.dequeue());
                }
            } catch (InterruptedException ie) {

            }
        });

        t1.start();
        Thread.sleep(4000);
        t2.start();
        t2.join();

        t3.start();
        t1.join();
        t3.join();

    }
}

class BlockingQueueWithSemaphore<T> {
    T[] queue;
    int size = 0;
    int capacity;
    int head = 0;
    int tail = 0;
    CountingSemaphore semLock = new CountingSemaphore(1, 1);
    CountingSemaphore semProducer;
    CountingSemaphore semConsumer;

    public BlockingQueueWithSemaphore(int capacity) {
        this.capacity = capacity;
        queue = (T[]) new Object[capacity];
        semProducer = new CountingSemaphore(capacity, capacity);
        semConsumer = new CountingSemaphore(capacity, 0);
    }

    public void enqueue(T item) throws InterruptedException {
        semProducer.acquire();
        semLock.acquire();

        if (tail == capacity) {
            tail = 0;
        }

        queue[tail] = item;
        size++;
        tail++;
        semLock.release();
        semConsumer.release();
    }

    public T dequeue() throws InterruptedException {
        T item = null;
        semConsumer.acquire();
        semLock.acquire();

        if (head == capacity) {
            head = 0;
        }

        item = queue[head];
        queue[head] = null;
        size--;
        head++;

        semLock.release();
        semProducer.release();

        return item;
    }
}

class CountingSemaphore {
    int usedPermits = 0;
    int maxCount;

    public CountingSemaphore(int count) {
        this.maxCount = count;
    }

    public CountingSemaphore(int count, int initialPermits) {
        this.maxCount = count;
        this.usedPermits = this.maxCount - initialPermits;
    }

    public synchronized void acquire() throws InterruptedException {
        while (usedPermits == maxCount) {
            wait();
        }

        notify();
        usedPermits++;
    }

    public synchronized void release() throws InterruptedException {
        while (usedPermits == 0) {
            wait();
        }

        usedPermits--;
        notify();
    }
}
