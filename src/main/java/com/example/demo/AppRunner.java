package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author Geonguk Han
 * @since 2020-08-20
 */
@Component
public class AppRunner implements ApplicationRunner {
    @Autowired
    SampleService sampleService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        sampleService.method();

    }
}
