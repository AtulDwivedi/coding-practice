package com.atuldwivedi.cp.java.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Atul Dwivedi
 */
public class ThreadPrintsInSequence {
    public static void main(String[] args) throws InterruptedException {
        final int threadsCount = 3;
        final ResourceLock lock = new ResourceLock(threadsCount);
        Worker[] threads = new Worker[threadsCount];
        final AtomicInteger counter = new AtomicInteger(0);

        for (int i = 0; i < threadsCount; i++) {
            threads[i] = new Worker(lock, i, counter);
            threads[i].start();
        }

        Thread.sleep(10000);
        //System.out.println("Will try to shutdown now...");

        for (Worker worker : threads) {
            worker.shutdown();
        }
    }
}

class ResourceLock {
    public volatile int flag;
    public final int threadsCount;

    public ResourceLock(int threadsCount) {
        this.flag = 0;
        this.threadsCount = threadsCount;
    }
}

class Worker extends Thread {
    private final ResourceLock resourceLock;
    private final int threadNumber;
    private final AtomicInteger counter;
    private volatile boolean running = true;

    public Worker(ResourceLock resourceLock, int threadNumber, AtomicInteger counter) {
        this.resourceLock = resourceLock;
        this.threadNumber = threadNumber;
        this.counter = counter;
    }

    @Override
    public void run() {
        while (running) {
            try {
                synchronized (resourceLock) {
                    while (resourceLock.flag != threadNumber) {
                        resourceLock.wait();
                    }
                    //System.out.println("Thread:" + threadNumber + " value: " + counter.incrementAndGet());
                    System.out.print(counter.incrementAndGet() + "("+threadNumber+") ");
                    Thread.sleep(1000);
                    resourceLock.flag = (threadNumber + 1) % resourceLock.threadsCount;
                    if (resourceLock.flag == 0) {
                        System.out.println();
                    }
                    resourceLock.notifyAll();
                }
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
    }

    public void shutdown() {
        running = false;
    }
}
