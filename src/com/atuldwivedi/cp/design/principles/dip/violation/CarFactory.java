package com.atuldwivedi.cp.design.principles.dip.violation;

/**
 * @author Atul Dwivedi
 * @date 11/07/21
 */
public class CarFactory {
    public static void main(String[] args) {
        FordEngine fordEngine = new FordEngine();
        Car car = new Car();
        car.setEngine(fordEngine);
        car.drive();
    }
}

class Car {
    //Violation: Car depends on details(concrete FordEngine class) - bad design
    private FordEngine engine;

    public void setEngine(FordEngine engine) {
        this.engine = engine;
    }

    public void drive() {
        engine.start();
        System.out.println("Driving the car...");
        engine.stop();
    }
}

class FordEngine {

    public void start() {
        System.out.println("Ford Engine started.");
    }

    public void stop() {
        System.out.println("Ford Engine stopped.");
    }
}
