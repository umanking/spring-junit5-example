package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.ServiceLoader;

/**
 * @author Geonguk Han
 * @since 2020-08-20
 */
@Service
public class SampleService {

    public void method() {
        final ServiceLoader<CodeFactory> loader = ServiceLoader.load(CodeFactory.class);
        for (CodeFactory factory : loader) {
            final Base64.Encoder enc = factory.getEncoder("PNG");
            if (enc != null) {
                System.out.println(enc);

                break;
            }
        }
    }
}
