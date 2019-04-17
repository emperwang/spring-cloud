package com.cloud.parent.microservicediscovereurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class MicroserviceConfigClientRefresh {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConfigClientRefresh.class, args);
	}

}
