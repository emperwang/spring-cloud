package com.wk.cloud.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class feignConfig {
    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }
}
