package com.atuldwivedi.codingpractice.design.patterns.creational.factorymethod;

/**
 * @author Atul Dwivedi
 */
public class Ship implements Transport {
    @Override
    public void transport() {
        System.out.println("Transporting via ship...");
    }
}
