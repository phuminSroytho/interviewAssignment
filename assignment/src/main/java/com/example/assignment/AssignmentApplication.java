package com.example.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssignmentApplication {

    public static void main(String[] args) {
        AppLoadConfigProp.showValueConfig("conf/config.properties");
    }
}
