package com.cloud.parent.microservicediscovereurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class MicroserviceGetwayZuul {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceGetwayZuul.class, args);
	}

}
