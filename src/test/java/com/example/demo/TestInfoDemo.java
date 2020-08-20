package com.example.demo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Geonguk Han
 * @since 2020-08-20
 */
@DisplayName("TestInfo Demo")
public class TestInfoDemo {

    public TestInfoDemo(TestInfo testInfo) {
        assertEquals("TestInfo Demo", testInfo.getDisplayName());


    }

    @BeforeEach
    void setUp(TestInfo testInfo) {
        final String displayName = testInfo.getDisplayName();
        assertTrue(displayName.equals("TEST 1") || displayName.equals("test2()"));
    }

    @DisplayName("TEST 1")
    @Tag("my-tag")
    @Test
    void test1(TestInfo testInfo) {
        assertEquals("TEST 1", testInfo.getDisplayName());
        assertTrue(testInfo.getTags().contains("my-tag"));
    }

    @Test
    void test2() {
    }
}
