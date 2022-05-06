package com.atuldwivedi.codingpractice.design.patterns.behavioral.strategy.impl01;

/**
 * @author Atul Dwivedi
 */
public class Client {
    public static void main(String[] args) {
        NavigationStrategy cabNavigationStrategy = new CabNavigationStrategy();
        NavigationStrategy walkNavigationStrategy = new WalkNavigationStrategy();
        NavigationStrategy ptNavigationStrategy = new PublicTransportNavigationStrategy();

        Navigator navigator = new Navigator();
        navigator.setNavigatorStrategy(cabNavigationStrategy);

        navigator.navigate("Bangalore", "Delhi");
    }
}
