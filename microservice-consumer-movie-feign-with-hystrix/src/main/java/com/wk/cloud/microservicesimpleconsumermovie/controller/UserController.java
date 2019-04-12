package com.wk.cloud.microservicesimpleconsumermovie.controller;

import com.netflix.discovery.converters.Auto;
import com.wk.cloud.microservicesimpleconsumermovie.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserFeignClient userFeignClient;

    @GetMapping("/findid/{id}")
    public String findById(@PathVariable Long id){
       return  this.userFeignClient.findById(id);
    }
}
