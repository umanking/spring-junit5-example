package com.example.demo;

import java.util.Base64;

/**
 * @author Geonguk Han
 * @since 2020-08-20
 */
public interface CodeFactory {

    Base64.Encoder getEncoder(String encodingName);

    Base64.Decoder getDecoder(String encodingName);

}
