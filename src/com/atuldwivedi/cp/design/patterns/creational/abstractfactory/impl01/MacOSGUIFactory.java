package com.atuldwivedi.cp.design.patterns.creational.abstractfactory.impl01;

/**
 * @author Atul Dwivedi
 */
public class MacOSGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacOSCheckBox();
    }
}
