package com.atuldwivedi.cp.design.patterns.creational.factory.impl04;

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

    private final Map<String, Laptop> laptopRegistry = new HashMap<>();

    public void registerLaptop(String laptopType, Laptop laptop) {
        if (laptopType != null && laptop != null) {
            laptopRegistry.put(laptopType, laptop);
        }
    }

    public Laptop createLaptop(String laptopType) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return (laptopRegistry.get(laptopType)).createLaptop();
    }

}
