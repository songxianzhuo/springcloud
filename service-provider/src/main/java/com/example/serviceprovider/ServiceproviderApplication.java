package com.example.serviceprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ServiceproviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceproviderApplication.class, args);
    }

}
