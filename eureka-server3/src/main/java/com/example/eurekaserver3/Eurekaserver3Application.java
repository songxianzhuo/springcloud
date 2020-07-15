package com.example.eurekaserver3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Eurekaserver3Application {

    public static void main(String[] args) {
        SpringApplication.run(Eurekaserver3Application.class, args);
    }

}
