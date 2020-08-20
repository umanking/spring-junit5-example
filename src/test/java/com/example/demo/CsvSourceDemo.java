package com.example.demo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Geonguk Han
 * @since 2020-08-20
 */
public class CsvSourceDemo {

    @ParameterizedTest
    @CsvSource({
            "apple,1",
            "banana,2",
            "'lemon, lime', 0xF1"
    })
    void testWithCsvSource(String fruit, int rank) {
        print(fruit, rank);

        assertNotNull(fruit);
        assertNotEquals(0, rank);

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/two-column.csv", numLinesToSkip = 1)
    void testWithCsvFileSource(String country, int reference) {
        print(country, reference);

    }

    void print(String value, int num) {
        System.out.println(value + ", " + num);
    }
}
