package com.example.demo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * @author Geonguk Han
 * @since 2020-08-11
 */
public class AssumtionsTest {

    private final Calculator calculator = new Calculator();


    @Test
    void testOnlyOnCiServer() {
        assumeTrue("CI".equals(System.getenv("ENV")));

        // remainder of test
    }

    @Test
    @Disabled
    void testOnlyDeveloperWorkstation() {
        assertTrue("DEV".equals(System.getenv("ENV")),
                () -> "Aborting test: not on developer workstation");
    }
}
