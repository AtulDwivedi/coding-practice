package com.atuldwivedi.codingpractice.design.patterns.creational.factory.impl03;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Atul Dwivedi
 */
public class LaptopClient {

    static {
        try {
            Class.forName("com.robustbase.designpatterns.creational.factory.impl03.PersonalLaptop");
            Class.forName("com.robustbase.designpatterns.creational.factory.impl03.StudentLaptop");
            Class.forName("com.robustbase.designpatterns.creational.factory.impl03.BusinessLaptop");
        } catch (ClassNotFoundException any) {
            any.printStackTrace();
        }
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        LaptopFactory laptopFactory = LaptopFactory.instance();
        Laptop laptop = laptopFactory.createLaptop("BUSINESS");

        if (laptop != null) {
            laptop.start();
            laptop.operate();
            laptop.shutDown();
        }
    }

}
