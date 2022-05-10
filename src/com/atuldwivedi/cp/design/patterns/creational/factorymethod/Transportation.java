package com.atuldwivedi.cp.design.patterns.creational.factorymethod;

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
