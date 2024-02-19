package com.example.assignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppLoadConfigProp {
    public static final String VALUE_FORMAT = "Key : %s, \nValue : %s";

    public static void showValueConfig(String path) {
        try {
            String absolutePath = Thread.currentThread().getContextClassLoader().getResource("").getPath() + path;
            Properties loader = new Properties();
            loader.load(new FileInputStream(absolutePath));
            loader.forEach((key, value) -> {
                System.out.println(String.format("Key : %s, \nValue : %s", key, value));
            });
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }
}
