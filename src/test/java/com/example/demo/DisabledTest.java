package com.example.demo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * @author Geonguk Han
 * @since 2020-08-11
 */
public class DisabledTest {

    @Test
    @Disabled("Disabled until bug #42 has been resolved")
    void testWillBeSkipped() {

    }

    @Test
    void testWillBeExecuted() {

    }
}
