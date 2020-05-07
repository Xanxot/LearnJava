package com.company;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        TestClass testClass = new TestClass();
        xUnit.startTest(testClass, TestClass.class);


    }


}
