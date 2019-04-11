package com.wk.cloud.microservicesimpleconsumermovie.controller;

import com.wk.cloud.microservicesimpleconsumermovie.entity.User;
import com.wk.cloud.microservicesimpleconsumermovie.feign.FeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Autowired
    private FeignClient feignClient;

    @GetMapping("/findid/{id}")
    public String findById(@PathVariable Long id){
       return  this.feignClient.findById(id);
    }
}
