package com.kai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Payment8002Starter {
    public static void main(String[] args) {
        SpringApplication.run(Payment8002Starter.class, args);
    }
}
