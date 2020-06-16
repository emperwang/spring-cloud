package com.kai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsul80Starter {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsul80Starter.class, args);
    }
}
