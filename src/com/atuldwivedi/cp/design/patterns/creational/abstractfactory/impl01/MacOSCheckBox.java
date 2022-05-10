package com.atuldwivedi.cp.design.patterns.creational.abstractfactory.impl01;

/**
 * @author Atul Dwivedi
 */
public class MacOSCheckBox implements CheckBox {
    @Override
    public void draw() {
        System.out.println("MacOSCheckBox is drawn.");
    }
}
