package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import java.time.temporal.ChronoUnit;
import java.util.EnumSet;

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
    @ValueSource(ints = { 1, 2, 3 })
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
}
