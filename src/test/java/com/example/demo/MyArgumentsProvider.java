package com.example.demo;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

/**
 * @author Geonguk Han
 * @since 2020-08-20
 */
public class MyArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        System.out.println("extension content : " + context.getDisplayName());

        return Stream.of("apple", "banana").map(Arguments::of);
    }
}
