package com.atuldwivedi.codingpractice.design.patterns.behavioral.observer.impl01;

import java.io.File;

/**
 * @author Atul Dwivedi
 */
public class LogEventListener implements EventListener {
    private File log;

    public LogEventListener(File log) {
        this.log = log;
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Save log to " + log + ": Someone has performed " + eventType + " operation with the file named: " + file.getName());
    }
}
