package com.atuldwivedi.cp.design.patterns.creational.factory.impl02;

/**
 * @author Atul Dwivedi
 */
public class PersonalLaptop implements Laptop {
    @Override
    public void start() {
        System.out.println("PersonalLaptop started.");
    }

    @Override
    public void operate() {
        System.out.println("PersonalLaptop is being operated.");
    }

    @Override
    public void shutDown() {
        System.out.println("PersonalLaptop has been shut down.");
    }
}
