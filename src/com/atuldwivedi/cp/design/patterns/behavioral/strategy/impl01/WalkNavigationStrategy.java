package com.atuldwivedi.cp.design.patterns.behavioral.strategy.impl01;

/**
 * @author Atul Dwivedi
 */
public class WalkNavigationStrategy implements NavigationStrategy {
    @Override
    public void navigate(String source, String destination) {
        System.out.println("Walk from " + source + " to " + destination);
    }
}
