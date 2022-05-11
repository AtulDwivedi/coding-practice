package com.atuldwivedi.cp.design.patterns.structural.decorator.impl01;

/**
 * @author Atul Dwivedi
 */
public class Client {
    public static void main(String[] args) {
        Notifier notifier = new BaseNotifier();

        BaseNotifierDecorator baseNotifierDecorator = new BaseNotifierDecorator(notifier);
        SlackNotifierDecorator slackNotifierDecorator = new SlackNotifierDecorator(baseNotifierDecorator);
        SMSNotifierDecorator smsNotifierDecorator = new SMSNotifierDecorator(slackNotifierDecorator);

        smsNotifierDecorator.notify("Error rate increased to 25% in Kibana.");

        System.out.println();

        MSTeamsNotifierDecorator msTeamsNotifierDecorator = new MSTeamsNotifierDecorator(smsNotifierDecorator);
        msTeamsNotifierDecorator.notify("Error rate increased to 50% in Kibana.");
    }
}
