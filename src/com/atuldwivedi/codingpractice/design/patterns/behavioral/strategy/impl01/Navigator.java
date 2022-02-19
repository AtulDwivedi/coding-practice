package com.atuldwivedi.codingpractice.design.patterns.behavioral.strategy.impl01;

/**
 * @author Atul Dwivedi
 */
public class Navigator {
    private NavigationStrategy navigationStrategy;

    public void setNavigatorStrategy(NavigationStrategy navigationStrategy) {
        this.navigationStrategy = navigationStrategy;
    }

    public void navigate(String source, String destination) {
        navigationStrategy.navigate(source, destination);
    }
}
