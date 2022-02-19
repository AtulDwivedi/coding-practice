package com.atuldwivedi.codingpractice.designpatterns.creational.abstractfactory.impl01;

/**
 * @author Atul Dwivedi
 */
public class GUIApplication {
    private Button button;
    private CheckBox checkBox;

    public GUIApplication(GUIFactory guiFactory) {
        button = guiFactory.createButton();
        checkBox = guiFactory.createCheckBox();
    }

    public void draw() {
        button.draw();
        checkBox.draw();
    }
}
