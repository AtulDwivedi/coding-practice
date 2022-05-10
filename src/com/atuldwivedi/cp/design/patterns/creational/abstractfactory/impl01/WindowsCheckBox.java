package com.atuldwivedi.cp.design.patterns.creational.abstractfactory.impl01;

/**
 * @author Atul Dwivedi
 */
public class WindowsCheckBox implements CheckBox {
    @Override
    public void draw() {
        System.out.println("WindowsCheckBox is drawn.");
    }
}
