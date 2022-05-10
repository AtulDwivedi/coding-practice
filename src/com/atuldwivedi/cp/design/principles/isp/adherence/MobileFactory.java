package com.atuldwivedi.cp.design.principles.isp.adherence;

/**
 * @author Atul Dwivedi
 * @date 11/07/21
 */
public class MobileFactory {
    private Security security;
    private Employee employee;
    private Robot robot;

    public MobileFactory(Security security, Employee employee, Robot robot) {
        this.security = security;
        this.employee = employee;
        this.robot = robot;
    }

    public static void main(String[] args) {
        Security security = new Security();
        Employee employee = new Employee();
        Robot robot = new Robot();

        MobileFactory mobileFactory = new MobileFactory(security, employee, robot);

        mobileFactory.startTheWork();
    }

    public void startTheWork() {
        security.work();
        employee.work();
        robot.work();
    }
}

interface Workable {
    void work();
}

//Adherence: - good design
interface Feedable {
    void eat();
}

interface Chargeable {
    void charge();
}

class Security implements Workable, Feedable {
    @Override
    public void work() {
        System.out.println("Security Worker: Performing security check.");
    }

    @Override
    public void eat() {
        System.out.println("Security Worker: Eating food.");
    }
}

class Employee implements Workable, Feedable {
    @Override
    public void work() {
        System.out.println("Employee Worker: Manufacturing mobile.");
    }

    @Override
    public void eat() {
        System.out.println("Employee Worker: Eating food.");
    }
}

class Robot implements Workable, Chargeable {
    @Override
    public void work() {
        System.out.println("Robot Worker: Performing stress and durability test on mobile.");
    }

    @Override
    public void charge() {
        System.out.println("Robot Worker: Getting Charged up.");
    }
}
