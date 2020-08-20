package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Geonguk Han
 * @since 2020-08-20
 */
public class SharedTempDirectoryDemo {
    @TempDir
    static Path sharedTempDir;

    @Test
    void writeItemsToFile() throws IOException {

        Path file = sharedTempDir.resolve("test.txt");
        System.out.println(file);

        final FileWriter fileWriter = new FileWriter(file.toFile());
        fileWriter.write("hello world\n");
        fileWriter.write("hello world2");
        fileWriter.close();


        final List<String> actual = Files.readAllLines(file);
        System.out.println(actual);

        Assertions.assertAll(
                () -> assertEquals("hello world", actual.get(0)),
                () -> assertEquals("hello world2", actual.get(1))
        );
    }
}
