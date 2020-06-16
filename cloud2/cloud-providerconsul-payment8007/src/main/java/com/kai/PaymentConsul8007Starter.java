package com.kai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsul8007Starter {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsul8007Starter.class, args);
    }
}
