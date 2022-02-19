package com.atuldwivedi.codingpractice.designpatterns.creational.singleton.doublelocking;

/**
 * @author Atul Dwivedi
 * @date 03/07/21
 * <p>
 * An improved thread safe, lazy-instantiation implementation of Singleton Design Pattern using double locking mechanism.
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {

        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }

    public void doSomething() {
    }
}
