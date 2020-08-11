package com.example.demo;

/**
 * @author Geonguk Han
 * @since 2020-08-11
 */
public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        throw new ArithmeticException();
//        return a / b;
    }
}
