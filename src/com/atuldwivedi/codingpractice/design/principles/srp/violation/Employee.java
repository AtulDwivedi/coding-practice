package com.atuldwivedi.codingpractice.design.principles.srp.violation;

/**
 * @author Atul Dwivedi
 * @date 12/07/21
 */
public class Employee {
    public double calculatePay() {
        //pay calculation logic goes here
        return Double.MIN_NORMAL;
    }

    public void save() {
        //saving employee object into database logic goes here
    }

    public String reportHours() {
        //hour calculation logic goes here
        return "9 Hours/Day";
    }
}
