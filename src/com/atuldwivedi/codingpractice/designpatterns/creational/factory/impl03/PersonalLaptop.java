package com.atuldwivedi.codingpractice.designpatterns.creational.factory.impl03;

/**
 * @author Atul Dwivedi
 */
public class PersonalLaptop implements Laptop {

    static {
        LaptopFactory.instance().registerLaptop("PERSONAL", PersonalLaptop.class);
    }

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
