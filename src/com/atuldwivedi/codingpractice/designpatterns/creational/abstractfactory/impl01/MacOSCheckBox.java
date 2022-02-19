package com.atuldwivedi.codingpractice.designpatterns.creational.abstractfactory.impl01;

/**
 * @author Atul Dwivedi
 */
public class MacOSCheckBox implements CheckBox {
    @Override
    public void draw() {
        System.out.println("MacOSCheckBox is drawn.");
    }
}
