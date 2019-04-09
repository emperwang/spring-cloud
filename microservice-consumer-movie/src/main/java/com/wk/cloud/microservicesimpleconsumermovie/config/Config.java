package com.wk.cloud.microservicesimpleconsumermovie.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    /**
     * 在springboot1.4版本后，就不会自动生成restTemplate，需要自己创建然后注入使用
     * @return
     */
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
