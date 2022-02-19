package com.atuldwivedi.codingpractice.designpatterns.creational.abstractfactory.impl01;

/**
 * @author Atul Dwivedi
 */
public class WindowsGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}
