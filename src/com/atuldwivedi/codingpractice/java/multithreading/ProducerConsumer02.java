package com.atuldwivedi.codingpractice.java.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Atul Dwivedi
 */
public class ProducerConsumer02 {
    public static void main(String[] args) throws InterruptedException {
        final BlockingQueueWithMutex<Integer> bq = new BlockingQueueWithMutex<>(5);

        Thread producer1 = new Thread(() -> {
            try {
                int i = 1;
                while (true) {
                    bq.enqueue(i);
                    System.out.println("Producer Thread 1 enqueued " + i);
                    i++;
                }
            } catch (InterruptedException ie) {

            }
        });

        Thread producer2 = new Thread(() -> {
            try {
                int i = 5000;
                while (true) {
                    bq.enqueue(i);
                    System.out.println("Producer Thread 2 enqueued " + i);
                    i++;
                }
            } catch (InterruptedException ie) {

            }
        });

        Thread producer3 = new Thread(() -> {
            try {
                int i = 100000;
                while (true) {
                    bq.enqueue(i);
                    System.out.println("Producer Thread 3 enqueued " + i);
                    i++;
                }
            } catch (InterruptedException ie) {

            }
        });

        Thread consumer1 = new Thread(() -> {
            try {
                while (true) {
                    System.out.println("Consumer Thread 1 dequeued " + bq.dequeue());
                }
            } catch (InterruptedException e) {

            }
        });

        Thread consumer2 = new Thread(() -> {
            try {
                while (true) {
                    System.out.println("Consumer Thread 2 dequeued " + bq.dequeue());
                }
            } catch (InterruptedException e) {

            }
        });

        Thread consumer3 = new Thread(() -> {
            try {
                while (true) {
                    System.out.println("Consumer Thread 3 dequeued " + bq.dequeue());
                }
            } catch (InterruptedException e) {

            }
        });

        producer1.setDaemon(true);
        producer2.setDaemon(true);
        producer3.setDaemon(true);
        consumer1.setDaemon(true);
        consumer2.setDaemon(true);
        consumer3.setDaemon(true);

        producer1.start();
        producer2.start();
        producer3.start();

        consumer1.start();
        consumer2.start();
        consumer3.start();

        Thread.sleep(1000);
    }
}

class BlockingQueueWithMutex<T> {
    T[] queue;
    int size = 0;
    int capacity;
    int head = 0;
    int tail = 0;
    Lock lock = new ReentrantLock();

    public BlockingQueueWithMutex(int capacity) {
        queue = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public void enqueue(T item) throws InterruptedException {
        lock.lock();
        while (size == capacity) {
            lock.unlock();
            lock.lock();
        }

        if (tail == capacity) {
            tail = 0;
        }

        queue[tail] = item;
        tail++;
        size++;
        lock.unlock();
    }

    public T dequeue() throws InterruptedException {
        T item = null;

        lock.lock();
        while (size == 0) {
            lock.unlock();
            lock.lock();
        }

        if (head == capacity) {
            head = 0;
        }

        item = queue[head];
        queue[head] = null;
        size--;
        head++;
        lock.unlock();

        return item;
    }
}
