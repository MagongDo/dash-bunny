package com.devcourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DashBunnyApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DashBunnyApplication.class);
        app.setAdditionalProfiles("Dev");
        app.run(args);
    }

}
