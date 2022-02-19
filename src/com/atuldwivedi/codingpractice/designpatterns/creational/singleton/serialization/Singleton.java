package com.atuldwivedi.codingpractice.designpatterns.creational.singleton.serialization;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @author Atul Dwivedi
 * @date 03/07/21
 * <p>
 * An improved thread safe, serializable, lazy-instantiation implementation of Singleton Design Pattern using double locking mechanism.
 */
public class Singleton implements Serializable {

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

    //on de-serialization this method will be called and will return singleton instance
    protected Object readResolve() throws ObjectStreamException {
        return getInstance();
    }

    public void doSomething() {
    }
}
