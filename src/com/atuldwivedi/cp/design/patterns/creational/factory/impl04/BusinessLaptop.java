package com.atuldwivedi.cp.design.patterns.creational.factory.impl04;


/**
 * @author Atul Dwivedi
 */
public class BusinessLaptop extends Laptop {

    static {
        LaptopFactory.instance().registerLaptop("BUSINESS", new BusinessLaptop());
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

    @Override
    public Laptop createLaptop() {
        return new BusinessLaptop();
    }
}
