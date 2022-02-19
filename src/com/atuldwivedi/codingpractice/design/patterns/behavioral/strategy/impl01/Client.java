package com.atuldwivedi.codingpractice.design.patterns.behavioral.strategy.impl01;

/**
 * @author Atul Dwivedi
 */
public class Client {
    public static void main(String[] args) {
        Navigator navigator = new Navigator();
        NavigationStrategy navigationStrategy = new CabStrategy();
        navigator.setNavigatorStrategy(navigationStrategy);

        navigator.navigate("Bangalore", "Delhi");
    }
}
