package com.atuldwivedi.codingpractice.designpatterns.structural.decorator.impl01;

/**
 * @author Atul Dwivedi
 */
public class BaseNotifierDecorator implements Notifier {

    private Notifier notifier;

    public BaseNotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void notify(String message) {
        notifier.notify(message);
    }
}
