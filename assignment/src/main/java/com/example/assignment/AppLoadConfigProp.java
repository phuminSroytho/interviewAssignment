package com.example.assignment;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Slf4j
public class AppLoadConfigProp {
    public static final String VALUE_FORMAT = "Key : %s, \nValue : %s";

    public static void showValueConfig(String path) {
        try {
            String absolutePath = Thread.currentThread().getContextClassLoader().getResource("").getPath() + path;
            Properties loader = new Properties();
            loader.load(new FileInputStream(absolutePath));
            loader.forEach((key, value) -> log.info(String.format(VALUE_FORMAT, key, value)));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private AppLoadConfigProp() throws IllegalAccessException {
        throw new IllegalAccessException();
    }
}
