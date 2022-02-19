package com.atuldwivedi.codingpractice.designpatterns.creational.factorymethod;

/**
 * @author Atul Dwivedi
 */
public class AirTransportation extends Transportation {
    @Override
    protected Transport createTransportation() {
        return new Plane();
    }
}
