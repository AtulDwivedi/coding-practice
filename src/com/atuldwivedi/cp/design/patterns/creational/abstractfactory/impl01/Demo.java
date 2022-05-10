package com.atuldwivedi.cp.design.patterns.creational.abstractfactory.impl01;

/**
 * @author Atul Dwivedi
 */
public class Demo {
    public static void main(String[] args) {
        GUIApplication application = configureApplication();
        application.draw();
    }

    private static GUIApplication configureApplication() {
        GUIApplication guiApplication;
        GUIFactory guiFactory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            guiFactory = new MacOSGUIFactory();
            guiApplication = new GUIApplication(guiFactory);
        } else {
            guiFactory = new WindowsGUIFactory();
            guiApplication = new GUIApplication(guiFactory);
        }
        return guiApplication;
    }
}
