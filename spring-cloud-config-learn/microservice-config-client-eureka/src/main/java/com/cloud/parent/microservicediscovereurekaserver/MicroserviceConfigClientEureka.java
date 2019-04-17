package com.cloud.parent.microservicediscovereurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceConfigClientEureka {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConfigClientEureka.class, args);
	}

}
