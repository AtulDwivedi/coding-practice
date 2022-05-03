package com.atuldwivedi.codingpractice.design.patterns.structural.decorator.impl01;

/**
 * @author Atul Dwivedi
 */
public class Client {
    public static void main(String[] args) {
        Notifier notifier = new BaseNotifier();
        BaseNotifierDecorator baseNotifierDecorator = new BaseNotifierDecorator(notifier);
        SlackDecorator slackDecorator = new SlackDecorator(baseNotifierDecorator);
        SMSDecorator smsDecorator = new SMSDecorator(slackDecorator);

        smsDecorator.notify("Error rate increased to 25% in Kibana.");

        System.out.println();

        MSTeamsDecorator msTeamsDecorator = new MSTeamsDecorator(smsDecorator);
        msTeamsDecorator.notify("Error rate increased to 50% in Kibana.");
    }
}
