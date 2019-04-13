package com.cloud.parent.microservicediscovereurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class MicroserviceGetwayZuulFallback {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceGetwayZuulFallback.class, args);
	}

	@Bean
	public MyZuulFilter getMyZuulFilter(){
		return new MyZuulFilter();
	}
}
