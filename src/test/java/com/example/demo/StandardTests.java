package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * @author Geonguk Han
 * @since 2020-08-11
 */
public class StandardTests {

    @Test
    @DisplayName("어보트 테스트")
    void abort_test() {
        assumeTrue("abc".contains("z"));
        fail("test should hav bean aborted");

    }
}
