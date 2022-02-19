package com.atuldwivedi.codingpractice.design.patterns.structural.decorator.impl01;

/**
 * @author Atul Dwivedi
 */
public class BaseNotifier implements Notifier {
    @Override
    public void notify(String message) {
        System.out.println("Notifying over email.");
    }
}
