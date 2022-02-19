package com.atuldwivedi.codingpractice.design.patterns.creational.factory.impl03;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Atul Dwivedi
 */
public class LaptopFactory {

    private static final LaptopFactory laptopFactory = new LaptopFactory();

    private LaptopFactory() {

    }

    public static LaptopFactory instance() {
        return laptopFactory;
    }

    private final Map<String, Class<Laptop>> laptopRegistry = new HashMap<>();

    public void registerLaptop(String laptopType, Class laptopClass) {
        if (laptopType != null && laptopClass != null) {
            laptopRegistry.put(laptopType, laptopClass);
        }
    }

    public Laptop createLaptop(String laptopType) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Laptop> productClass = laptopRegistry.get(laptopType);
        Constructor<Laptop> laptopConstructor = productClass.getDeclaredConstructor();
        return laptopConstructor.newInstance();
    }

}
