package com.atuldwivedi.codingpractice.design.principles.dip.adherence;

/**
 * @author Atul Dwivedi
 * @date 11/07/21
 */
public class CarFactory {

    public static void main(String[] args) {
        FordEngine fordEngine = new FordEngine();
        Car car1 = new Car();
        car1.setEngine(fordEngine);
        car1.drive();

        System.out.println("");

        FerrariEngine ferrariEngine = new FerrariEngine();
        Car car2 = new Car();
        car2.setEngine(ferrariEngine);
        car2.drive();
    }
}

class Car {

    //Adherence: Car depends on abstraction(Engine interface) - good design
    private Engine engine;

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void drive() {
        engine.start();
        System.out.println("Driving the car...");
        engine.stop();
    }
}

interface Engine {
    void start();

    void stop();
}

class FordEngine implements Engine {

    public void start() {
        System.out.println("Ford Engine started.");
    }

    public void stop() {
        System.out.println("Ford Engine stopped.");
    }
}

class FerrariEngine implements Engine {

    public void start() {
        System.out.println("Ferrari Engine started.");
    }

    public void stop() {
        System.out.println("Ferrari Engine stopped.");
    }
}
