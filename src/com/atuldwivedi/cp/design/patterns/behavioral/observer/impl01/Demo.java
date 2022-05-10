package com.atuldwivedi.cp.design.patterns.behavioral.observer.impl01;

import java.io.File;

/**
 * @author Atul Dwivedi
 */
public class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();

        EmailEventListener emailEventListener = new EmailEventListener("abc@xyz.com");
        LogEventListener logEventListener = new LogEventListener(new File("log.txt"));

        editor.eventManager.subscribe("open", emailEventListener);
        editor.eventManager.subscribe("save", logEventListener);

        try {
            editor.open("test.txt");
            editor.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
