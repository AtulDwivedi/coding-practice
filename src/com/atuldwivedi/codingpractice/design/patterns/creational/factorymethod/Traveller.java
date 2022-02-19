package com.atuldwivedi.codingpractice.design.patterns.creational.factorymethod;

/**
 * @author Atul Dwivedi
 */
public class Traveller {
    public static void main(String[] args) {
        Transportation transportation = new SeaTransportation();
        transportation.transport();
    }
}
