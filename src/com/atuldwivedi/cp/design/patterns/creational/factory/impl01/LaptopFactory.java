package com.atuldwivedi.cp.design.patterns.creational.factory.impl01;

/**
 * @author Atul Dwivedi
 * @date 04/07/21
 */
public class LaptopFactory {

    private static LaptopFactory laptopFactory = new LaptopFactory();

    private LaptopFactory(){

    }

    public static LaptopFactory instance() {
        return laptopFactory;
    }

    public Laptop createLaptop(String laptopType) {
        if (laptopType.equals("PERSONAL")) {
            return new PersonalLaptop();
        }
        if (laptopType.equals("STUDENT")) {
            return new StudentLaptop();
        }
        if (laptopType.equals("BUSINESS")) {
            return new BusinessLaptop();
        }
        return null;
    }

}
