package com.atuldwivedi.codingpractice.designpatterns.behavioral.strategy.impl01;

/**
 * @author Atul Dwivedi
 */
public class PublicTransportStrategy implements NavigationStrategy {
    @Override
    public void navigate(String source, String destination) {
        System.out.println("Take public transport from " + source + " to " + destination);
    }
}
