package com.cloud.parent.microservicediscovereurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
public class MicroserviceConfigServer {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConfigServer.class, args);
	}

}
