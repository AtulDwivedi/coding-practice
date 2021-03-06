package com.atuldwivedi.cp.design.patterns.behavioral.observer.impl01;

import java.io.File;

/**
 * @author Atul Dwivedi
 */
public class EmailEventListener implements EventListener {
    private String email;

    public EmailEventListener(String email) {
        this.email = email;
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Email to " + email + ": Someone has performed " + eventType + " operation with the file named: " + file.getName());
    }
}
