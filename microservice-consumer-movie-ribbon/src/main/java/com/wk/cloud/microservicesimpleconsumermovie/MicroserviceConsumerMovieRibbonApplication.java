package com.wk.cloud.microservicesimpleconsumermovie;

import com.wk.cloud.config.RibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "MICROSERVICE-PROVIDE-USER",configuration = RibbonConfiguration.class)
public class MicroserviceConsumerMovieRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConsumerMovieRibbonApplication.class, args);
	}

}
