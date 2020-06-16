package com.kai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentZk8005Starter {
    public static void main(String[] args) {
        SpringApplication.run(PaymentZk8005Starter.class, args);
    }
}
