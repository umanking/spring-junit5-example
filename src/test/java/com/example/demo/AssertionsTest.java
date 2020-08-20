package com.example.demo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Geonguk Han
 * @since 2020-08-11
 */
public class AssertionsTest {

    private final Calculator calculator = new Calculator();

    private final Person person = new Person("Jane", "Doe");

    @Test
    void calculatorTest() {
        assertEquals(2, calculator.add(1, 1));
        assertEquals(4, calculator.multiply(2, 2), "something wrong");
        assertTrue('a' < 'b', () -> "blah blah");

    }

    @Test
    void groupAssertions() {

        assertAll(
                "person",
                () -> assertEquals("Jane", person.getFirstName()),
                () -> assertEquals("Doe", person.getLastName()));
    }

    @Test
    void exceptionTesting() {
        final ArithmeticException exception = assertThrows(ArithmeticException.class, () -> calculator.divide(0, 0));
    }

    @Test
    void timeoutNotExceeded() {
        assertTimeout(Duration.ofSeconds(5), ()-> {
            // 5초를 초과하는 경우에는 time out exception 발생
            // API call test 할때 유용 할 듯
//            Thread.sleep(10000);
            System.out.println("after 10 seconds");
        });
    }

    @Test
    void timeoutNotExceededWithResult() {
        final String actualResult = assertTimeout(Duration.ofSeconds(5), () -> {
            return "a result";
        });

        assertEquals("a result", actualResult);
    }

    @Test
    void timeoutNotExceededWithMethod() {
        final String actualResult = assertTimeout(Duration.ofSeconds(5), AssertionsTest::greeting);

        assertEquals("hello world", actualResult);
    }

    private static String greeting() {
        return "hello world";
    }

    @Test
    @Disabled
    void timeoutExceeded() {

        assertTimeout(Duration.ofMillis(10), ()-> {
            Thread.sleep(100);

        });
    }
}
