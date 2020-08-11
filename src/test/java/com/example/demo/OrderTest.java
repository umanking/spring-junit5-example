package com.example.demo;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * @author Geonguk Han
 * @since 2020-08-11
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderTest {


    @Test
    @Order(1)
    void nullValue() {

    }

    @Test
    @Order(2)
    void emptyValue() {

    }

    @Test
    @Order(3)
    void validValues() {

    }

}
