package com.example.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.parallel.Resources.SYSTEM_PROPERTIES;

/**
 * @author Geonguk Han
 * @since 2020-08-20
 */
@Execution(ExecutionMode.CONCURRENT)
public class SharedResourceDemo {

    private Properties backup;

    @BeforeEach
    void setBackup() {
        backup = new Properties();
        backup.putAll(System.getProperties());
    }

    @AfterEach
    void restore() {
        System.setProperties(backup);
    }

    @Test
    @ResourceLock(value = SYSTEM_PROPERTIES, mode = ResourceAccessMode.READ)
    void customPropertyISNotSetByDefault() {
        assertNull(System.getProperty("my.prop"));
    }
}
