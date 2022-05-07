package com.atuldwivedi.codingpractice.java.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Atul Dwivedi
 */
public class DeadLock {
    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        new Thread(deadLock::operation1, "T1").start();
        new Thread(deadLock::operation2, "T2").start();
    }

    public void operation1() {
        lock1.lock();
        System.out.println("lock1 acquired. waiting to acquire lock2");
        sleep(1000);

        lock2.lock();
        System.out.println("lock2 acquired.");

        System.out.println("performing operation1...");

        lock2.unlock();
        lock1.unlock();
    }

    public void operation2() {
        lock2.lock();
        System.out.println("lock2 acquired. waiting to acquire lock1");
        sleep(1000);

        lock1.lock();
        System.out.println("lock1 acquired.");

        System.out.println("performing operation2...");

        lock1.unlock();
        lock2.unlock();
    }

    public void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {

        }
    }
}
