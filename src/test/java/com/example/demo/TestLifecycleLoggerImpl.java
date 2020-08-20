package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Geonguk Han
 * @since 2020-08-20
 */
public class TestLifecycleLoggerImpl implements TestLifecycleLogger {

    @Test
    void hello() {
        String hello = "hello";
        assertEquals(hello, "hello");
    }
}
