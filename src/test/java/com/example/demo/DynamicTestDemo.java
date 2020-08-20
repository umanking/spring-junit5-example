package com.example.demo;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

/**
 * @author Geonguk Han
 * @since 2020-08-20
 */
public class DynamicTestDemo {

    private final Calculator calculator = new Calculator();

    // must return a single org.junit.jupiter.api.DynamicNode or a Stream, Collection, Iterable, Iterator, or array of org.junit.jupiter.api.DynamicNode.
    // this will result in a JunitException
    @TestFactory
    List<String> dynamicTestWithInvalidReturnType() {
        return Arrays.asList("hello");
    }
    @TestFactory
    Collection<DynamicTest> dynamicTestsFromCollection() {
        return Arrays.asList(dynamicTest("1nd dynamic test", () -> assertEquals(4, calculator.multiply(2, 2))));
    }

    @TestFactory
    Iterable<DynamicTest> dynamicTestCollections() {
        return Arrays.asList(dynamicTest("2nd dynamic test", () -> assertEquals(4, calculator.multiply(2, 2))));
    }

    @TestFactory
    Iterator<DynamicTest> dynamicTestIterator() {
        return Arrays.asList(dynamicTest("3nd dynamic test", () -> assertEquals(4, calculator.multiply(2, 2)))).iterator();
    }

    @TestFactory
    Stream<DynamicTest> dynamicTestStream() {
        return IntStream.iterate(0, n -> n + 2).limit(10)
                .mapToObj(n -> dynamicTest("test" , () -> assertTrue(n % 2 == 0)));
    }

}
