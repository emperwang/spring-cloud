package com.wk.cloud.microservicesimpleconsumermovie.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wk.cloud.microservicesimpleconsumermovie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 这里的HystrixCommand 就是断路器的注解
     * @param id
     * @return
     */
    @GetMapping("/cfind/{id}")
    @HystrixCommand(fallbackMethod = "findFallback")
    public User findById(@PathVariable Long id){
        return restTemplate.getForObject("http://MICROSERVICE-PROVIDE-USER/find/"+id,User.class);
    }

    public User findFallback(Long id){
        User user = new User();
        user.setId(00L);
        return user;
    }
}
