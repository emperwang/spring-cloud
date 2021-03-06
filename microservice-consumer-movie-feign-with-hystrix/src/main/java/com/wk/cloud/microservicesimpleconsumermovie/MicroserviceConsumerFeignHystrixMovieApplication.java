package com.wk.cloud.microservicesimpleconsumermovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker   //此注解打开hystrix.stream监控
public class MicroserviceConsumerFeignHystrixMovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConsumerFeignHystrixMovieApplication.class, args);
	}

}
