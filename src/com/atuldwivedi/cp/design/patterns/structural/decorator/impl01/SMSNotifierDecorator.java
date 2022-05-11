package com.atuldwivedi.cp.design.patterns.structural.decorator.impl01;

/**
 * @author Atul Dwivedi
 */
public class SMSNotifierDecorator extends BaseNotifierDecorator {

    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void notify(String message) {
        super.notify(message);
        System.out.println("Notifying over SMS.");
    }
}
