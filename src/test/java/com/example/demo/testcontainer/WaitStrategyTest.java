package com.example.demo.testcontainer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

/**
 * @author Geonguk Han
 * @since 2020-08-21
 */
@TestConfiguration
@SpringBootTest
public class WaitStrategyTest {

    @Container
    public GenericContainer nginx = new GenericContainer("nginx:1.9.4")
            .withExposedPorts(80)
            .waitingFor(Wait.forHttp("/"));


    @BeforeEach


    @Test
    void name() {
    }
}
