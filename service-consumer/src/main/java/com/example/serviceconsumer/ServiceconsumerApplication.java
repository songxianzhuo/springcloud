package com.example.serviceconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ServiceconsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceconsumerApplication.class, args);
    }

}
