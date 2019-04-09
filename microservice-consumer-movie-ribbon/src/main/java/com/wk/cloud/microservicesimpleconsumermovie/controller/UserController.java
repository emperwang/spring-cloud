package com.wk.cloud.microservicesimpleconsumermovie.controller;

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

    @GetMapping("/cfind/{id}")
    public User findById(@PathVariable Long id){
        return restTemplate.getForObject("http://MICROSERVICE-PROVIDE-USER/find/"+id,User.class);
    }
}
