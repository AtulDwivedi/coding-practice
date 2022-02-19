package com.atuldwivedi.codingpractice.designpatterns.structural.decorator.impl01;

/**
 * @author Atul Dwivedi
 */
public class SlackDecorator extends BaseNotifierDecorator {
    public SlackDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void notify(String message) {
        super.notify(message);
        System.out.println("Notifying over Slack.");
    }
}
