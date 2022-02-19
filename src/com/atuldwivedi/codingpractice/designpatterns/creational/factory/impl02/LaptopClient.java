package com.atuldwivedi.codingpractice.designpatterns.creational.factory.impl02;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Atul Dwivedi
 * @date 04/07/21
 */
public class LaptopClient {

    static {
        try {
            Class.forName("com.robustbase.designpatterns.creational.factory.impl02.PersonalLaptop");
            Class.forName("com.robustbase.designpatterns.creational.factory.impl02.StudentLaptop");
            Class.forName("com.robustbase.designpatterns.creational.factory.impl02.BusinessLaptop");
        } catch (ClassNotFoundException any) {
            any.printStackTrace();
        }
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        LaptopFactory laptopFactory = LaptopFactory.instance();
        laptopFactory.registerLaptop("PERSONAL", PersonalLaptop.class);
        laptopFactory.registerLaptop("STUDENT", StudentLaptop.class);
        laptopFactory.registerLaptop("BUSINESS", BusinessLaptop.class);

        Laptop laptop = laptopFactory.createLaptop("STUDENT");

        if (laptop != null) {
            laptop.start();
            laptop.operate();
            laptop.shutDown();
        }
    }

}
