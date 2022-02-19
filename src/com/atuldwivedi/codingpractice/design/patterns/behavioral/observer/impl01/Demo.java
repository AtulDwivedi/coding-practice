package com.atuldwivedi.codingpractice.design.patterns.behavioral.observer.impl01;

import java.io.File;

/**
 * @author Atul Dwivedi
 */
public class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.eventManager.subscribe("open", new EmailNotificationListener("abc@xyz.com"));
        editor.eventManager.subscribe("save", new LogListener(new File("log.txt")));

        try {
            editor.open("test.txt");
            editor.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
