package com.kai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class ProviderHystrixPayment8010 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderHystrixPayment8010.class, args);
    }
}
