package com.wk.cloud.config;

import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class feignConfig2 {
    /**
     * 如果eureka设置了密码,这里的bean就是认证密码的
     * @return
     */
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("user", "passwd123");
    }

    /**
     * 禁用feignClient2的hystrix
     * @return
     */
    @Bean
    @Scope("prototype")
     public Feign.Builder feignBuilder(){
         return Feign.builder();
     }
}
