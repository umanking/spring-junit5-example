package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.junit.platform.commons.util.StringUtils;

import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.EnumSource.Mode.MATCH_ALL;
import static org.junit.jupiter.params.provider.EnumSource.Mode.MATCH_ANY;

/**
 * @author Geonguk Han
 * @since 2020-08-20
 */
public class ParameterizedDemo {

    @ParameterizedTest
    @ValueSource(strings = {"racecar", "radar", "able was I ere I saw elba"})
    void stringBlankTest(String candidate) {
        System.out.println(candidate);
        assertTrue(StringUtils.isNotBlank(candidate));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testWithValueSource(int argument) {
        assertTrue(argument > 0 && argument < 4);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"", "  ", "\t", "\n"})
    public void nullEmptyAndBlankStrings(String text) {
        assertTrue(text == null || text.trim().isEmpty());
    }

    @ParameterizedTest
    @EnumSource(Fruit.class)
    void testWithEnumSource(Fruit fruit) {
        assertNotNull(fruit);
    }

    @ParameterizedTest
    @EnumSource(names = {"APPLE"})
    void testWithEnumSourceInclude(Fruit fruit) {
        System.out.println(fruit);
        assertTrue(EnumSet.of(Fruit.APPLE, Fruit.BANANA).contains(fruit));
    }

    @ParameterizedTest
    @EnumSource(mode = EnumSource.Mode.EXCLUDE, names = {"ORANGE"})
    void testWithEnumSourceExclude(Fruit fruit) {
        System.out.println(fruit);
        assertFalse(EnumSet.of(Fruit.ORANGE).contains(fruit));
    }

    @ParameterizedTest
    @EnumSource(mode = MATCH_ANY, names = "^BANANA$")
    void testWithEnumSourceReg(Fruit fruit) {
        System.out.println(fruit);
    }


    @ParameterizedTest
    @EnumSource(mode = MATCH_ALL, names = "^.*DAYS$")
    void testWithEnumSourceRegex(ChronoUnit unit) {
        System.out.println(unit);
        assertTrue(unit.name().endsWith("DAYS"));
    }
    enum Fruit {
        APPLE, ORANGE, BANANA;

    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testWithExplicitLocalMethodSource(String argument) {
        System.out.println(argument);
        assertNotNull(argument);
    }

    static Stream<String> stringProvider() {
        return Stream.of("apple", "banana");
    }

    @ParameterizedTest
    @MethodSource("range")
    void testWithRangeMethodSource(int argument) {
        System.out.println(argument);
        assertNotEquals(9, argument);
    }

    static IntStream range() {
        return IntStream.range(0, 20).skip(10);
    }


    @ParameterizedTest
    @MethodSource("stringIntAndListProvider")
    void testWithMultiArgMethodSource(String str, int num, List<String> list) {
        assertEquals(5, str.length());
        assertTrue(num >=1 && num <=2);
        assertEquals(2, list.size());
    }

    static Stream<Arguments> stringIntAndListProvider() {
        return Stream.of(
                Arguments.arguments("apple", 1, Arrays.asList("a", "b")),
                Arguments.arguments("lemon", 2, Arrays.asList("x", "y"))
        );
    }
}
