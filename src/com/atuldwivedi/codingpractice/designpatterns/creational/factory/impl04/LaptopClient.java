package com.atuldwivedi.codingpractice.designpatterns.creational.factory.impl04;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Atul Dwivedi
 */
public class LaptopClient {

    static {
        try {
            Class.forName("com.robustbase.designpatterns.creational.factory.impl04.PersonalLaptop");
            Class.forName("com.robustbase.designpatterns.creational.factory.impl04.StudentLaptop");
            Class.forName("com.robustbase.designpatterns.creational.factory.impl04.BusinessLaptop");
        } catch (ClassNotFoundException any) {
            any.printStackTrace();
        }
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        LaptopFactory laptopFactory = LaptopFactory.instance();
        Laptop laptop = laptopFactory.createLaptop("PERSONAL");

        if (laptop != null) {
            laptop.start();
            laptop.operate();
            laptop.shutDown();
        }
    }

}
