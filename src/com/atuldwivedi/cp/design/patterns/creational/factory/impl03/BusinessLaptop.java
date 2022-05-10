package com.atuldwivedi.cp.design.patterns.creational.factory.impl03;


/**
 * @author Atul Dwivedi
 */
public class BusinessLaptop implements Laptop {

    static {
        LaptopFactory.instance().registerLaptop("BUSINESS", BusinessLaptop.class);
    }

    @Override
    public void start() {
        System.out.println("BusinessLaptop started.");
    }

    @Override
    public void operate() {
        System.out.println("BusinessLaptop is being operated.");
    }

    @Override
    public void shutDown() {
        System.out.println("BusinessLaptop has been shut down.");
    }
}
