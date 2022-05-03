package com.atuldwivedi.codingpractice.java.multithreading;

/**
 * @author Atul Dwivedi
 */
public class ProducerConsumer01 {
    public static void main(String[] args) throws InterruptedException {
        final BlockingQueueWithMutex<Integer> bq = new BlockingQueueWithMutex<>(5);

        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 50; i++) {
                    bq.enqueue(i);
                    System.out.println("Thread 1 enqueued " + i);
                }
            } catch (InterruptedException ie) {

            }
        });

        Thread consumer1 = new Thread(() -> {
            try {
                for (int i = 0; i < 25; i++) {
                    System.out.println("Thread 2 dequeued " + bq.dequeue());
                }
            } catch (InterruptedException e) {

            }
        });

        Thread consumer2 = new Thread(() -> {
            try {
                for (int i = 0; i < 25; i++) {
                    System.out.println("Thread 3 dequeued " + bq.dequeue());
                }
            } catch (InterruptedException e) {

            }
        });

        producer.start();
        Thread.sleep(1000);
        consumer1.start();

        consumer1.join();

        consumer2.start();
        producer.join();
        consumer2.join();
    }
}

class BlockingQueue<T> {
    T[] queue;
    int size = 0;
    int capacity;
    int head = 0;
    int tail = 0;
    Object lock = new Object();

    public BlockingQueue(int capacity) {
        queue = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public void enqueue(T item) throws InterruptedException {
        synchronized (lock) {
            while (size == capacity) {
                lock.wait();
            }

            if (tail == capacity) {
                tail = 0;
            }

            queue[tail] = item;
            tail++;
            size++;
            lock.notifyAll();
        }
    }

    public T dequeue() throws InterruptedException {
        T item = null;

        synchronized (lock) {
            while (size == 0) {
                lock.wait();
            }

            if (head == capacity) {
                head = 0;
            }

            item = queue[head];
            queue[head] = null;
            size--;
            head++;
            lock.notifyAll();
        }
        return item;
    }
}
