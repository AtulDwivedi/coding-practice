package com.atuldwivedi.codingpractice.designpatterns.behavioral.strategy.impl01;

/**
 * @author Atul Dwivedi
 */
public class CabStrategy implements NavigationStrategy {
    @Override
    public void navigate(String source, String destination) {
        System.out.println("Hire cab from " + source + " to " + destination);
    }
}
