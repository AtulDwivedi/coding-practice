package com.atuldwivedi.cp.design.patterns.creational.abstractfactory.impl01;

/**
 * @author Atul Dwivedi
 */
public class MacOSButton implements Button {
    @Override
    public void draw() {
        System.out.println("MacOSButton is drawn.");
    }
}
