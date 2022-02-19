package com.atuldwivedi.codingpractice.design.patterns.creational.singleton;

/**
 * @author Atul Dwivedi
 * @date 03/07/21
 * <p>
 * A thread safe, lazy-instantiation implementation of Singleton Design Pattern.
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {

        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }

    public void doSomething() {
    }
}
