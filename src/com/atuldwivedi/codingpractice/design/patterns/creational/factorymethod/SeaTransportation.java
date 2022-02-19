package com.atuldwivedi.codingpractice.design.patterns.creational.factorymethod;

/**
 * @author Atul Dwivedi
 */
public class SeaTransportation extends Transportation {
    @Override
    protected Transport createTransportation() {
        return new Ship();
    }
}
