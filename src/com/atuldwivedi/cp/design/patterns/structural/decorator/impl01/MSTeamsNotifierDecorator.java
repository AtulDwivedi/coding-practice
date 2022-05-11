package com.atuldwivedi.cp.design.patterns.structural.decorator.impl01;

/**
 * @author Atul Dwivedi
 */
public class MSTeamsNotifierDecorator extends BaseNotifierDecorator {

    public MSTeamsNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void notify(String message) {
        super.notify(message);
        System.out.println("Notifying over Microsoft Teams.");
    }
}
