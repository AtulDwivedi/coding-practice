package com.atuldwivedi.codingpractice.designpatterns.creational.factory.impl02;

/**
 * @author Atul Dwivedi
 */
public class StudentLaptop implements Laptop {
    @Override
    public void start() {
        System.out.println("StudentLaptop started.");
    }

    @Override
    public void operate() {
        System.out.println("StudentLaptop is being operated.");
    }

    @Override
    public void shutDown() {
        System.out.println("StudentLaptop has been shut down.");
    }
}
