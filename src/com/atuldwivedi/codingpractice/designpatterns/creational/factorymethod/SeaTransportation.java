package com.atuldwivedi.codingpractice.designpatterns.creational.factorymethod;

/**
 * @author Atul Dwivedi
 */
public class SeaTransportation extends Transportation {
    @Override
    protected Transport createTransportation() {
        return new Ship();
    }
}
