package com.atuldwivedi.codingpractice.designpatterns.creational.factorymethod;

/**
 * @author Atul Dwivedi
 */
public class Plane implements Transport {
    @Override
    public void transport() {
        System.out.println("Transporting via plane...");
    }
}
