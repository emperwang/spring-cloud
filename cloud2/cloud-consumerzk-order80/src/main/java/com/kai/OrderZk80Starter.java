package com.kai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
//@RibbonClient
public class OrderZk80Starter {
    public static void main(String[] args) {
        SpringApplication.run(OrderZk80Starter.class, args);
    }
}
