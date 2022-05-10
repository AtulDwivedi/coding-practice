package com.atuldwivedi.cp.design.patterns.behavioral.strategy.impl01;

/**
 * @author Atul Dwivedi
 */
public class CabNavigationStrategy implements NavigationStrategy {
    @Override
    public void navigate(String source, String destination) {
        System.out.println("Hire cab from " + source + " to " + destination);
    }
}
