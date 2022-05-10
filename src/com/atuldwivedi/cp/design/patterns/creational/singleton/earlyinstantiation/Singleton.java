package com.atuldwivedi.cp.design.patterns.creational.singleton.earlyinstantiation;

/**
 * @author Atul Dwivedi
 * @date 03/07/21
 * <p>
 * A early-instantiation implementation of Singleton Design Pattern.
 */
public class Singleton {

    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }

    public void doSomething() {
    }
}
