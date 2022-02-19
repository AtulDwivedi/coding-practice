package com.atuldwivedi.codingpractice.designpatterns.creational.factorymethod;

/**
 * @author Atul Dwivedi
 */
public class RoadTransportation extends Transportation {
    @Override
    protected Transport createTransportation() {
        return new Bus();
    }
}
