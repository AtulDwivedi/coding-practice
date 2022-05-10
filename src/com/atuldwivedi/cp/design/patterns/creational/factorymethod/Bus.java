package com.atuldwivedi.cp.design.patterns.creational.factorymethod;

/**
 * @author Atul Dwivedi
 */
public class Bus implements Transport {
    @Override
    public void transport() {
        System.out.println("Transporting via bus...");
    }
}
