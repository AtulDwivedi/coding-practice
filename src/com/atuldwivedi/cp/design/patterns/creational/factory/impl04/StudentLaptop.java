package com.atuldwivedi.cp.design.patterns.creational.factory.impl04;

/**
 * @author Atul Dwivedi
 */
public class StudentLaptop extends Laptop {

    static {
        LaptopFactory.instance().registerLaptop("STUDENT", new StudentLaptop());
    }

    @Override
    public Laptop createLaptop() {
        return new StudentLaptop();
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
