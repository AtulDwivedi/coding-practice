package com.atuldwivedi.cp.design.patterns.creational.factory.impl03;

/**
 * @author Atul Dwivedi
 */
public class StudentLaptop implements Laptop {

    static {
        LaptopFactory.instance().registerLaptop("STUDENT", StudentLaptop.class);
    }

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
