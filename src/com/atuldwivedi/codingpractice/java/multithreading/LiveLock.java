package com.atuldwivedi.codingpractice.java.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Atul Dwivedi
 */
public class LiveLock {
    private Lock lock1 = new ReentrantLock(true);
}
