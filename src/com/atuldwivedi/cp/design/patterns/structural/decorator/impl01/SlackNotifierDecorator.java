package com.atuldwivedi.cp.design.patterns.structural.decorator.impl01;

/**
 * @author Atul Dwivedi
 */
public class SlackNotifierDecorator extends BaseNotifierDecorator {

    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void notify(String message) {
        super.notify(message);
        System.out.println("Notifying over Slack.");
    }
}
