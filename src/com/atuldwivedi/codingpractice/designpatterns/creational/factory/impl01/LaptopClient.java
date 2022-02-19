package com.atuldwivedi.codingpractice.designpatterns.creational.factory.impl01;

/**
 * @author Atul Dwivedi
 */
public class LaptopClient {

    public static void main(String[] args) {
        Laptop laptop = LaptopFactory.instance().createLaptop("BUSINESS");

        if (laptop != null) {
            laptop.start();
            laptop.operate();
            laptop.shutDown();
        } else {
            System.out.println("No laptop found for specified laptop type.");
        }
    }

}
