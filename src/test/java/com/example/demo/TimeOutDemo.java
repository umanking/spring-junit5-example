package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

/**
 * @author Geonguk Han
 * @since 2020-08-20
 */
public class TimeOutDemo {

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void failsIfExecutionTimeExceeds100Milliseconds() throws InterruptedException {
        Thread.sleep(200);

    }
}
