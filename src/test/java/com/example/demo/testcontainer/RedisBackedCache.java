package com.example.demo.testcontainer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Geonguk Han
 * @since 2020-08-21
 */
public class RedisBackedCache {

    private String address;
    private int port;

    public RedisBackedCache(String address, int port) {
        this.address = address;
        this.port = port;
    }

    private final Map<String, String> map = new HashMap<>();

    public void put(String test, String example) {
        map.put(test, example);
    }

    public String get(String test) {
        return map.get(test);
    }
}
