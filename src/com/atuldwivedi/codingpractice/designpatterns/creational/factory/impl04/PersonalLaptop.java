package com.atuldwivedi.codingpractice.designpatterns.creational.factory.impl04;

/**
 * @author Atul Dwivedi
 */
public class PersonalLaptop extends Laptop {

    static {
        LaptopFactory.instance().registerLaptop("PERSONAL", new PersonalLaptop());
    }

    @Override
    public Laptop createLaptop() {
        return new PersonalLaptop();
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
