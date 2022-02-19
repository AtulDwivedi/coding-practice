package com.atuldwivedi.codingpractice.designpatterns.creational.factorymethod;

/**
 * @author Atul Dwivedi
 */
public abstract class Transportation {

    public void transport() {
        Transport transport = createTransportation();
        transport.transport();
    }

    protected abstract Transport createTransportation();
}
