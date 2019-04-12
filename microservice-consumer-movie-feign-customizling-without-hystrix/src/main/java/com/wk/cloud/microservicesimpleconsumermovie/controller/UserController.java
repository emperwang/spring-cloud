package com.wk.cloud.microservicesimpleconsumermovie.controller;

import com.wk.cloud.microservicesimpleconsumermovie.feign.MyFeignClient1;
import com.wk.cloud.microservicesimpleconsumermovie.feign.MyFeignClient2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    //@Autowired
    @Resource
    private MyFeignClient1 feignClient1;

    @Autowired
    private MyFeignClient2 feignClient2;

    @GetMapping("/findid/{id}")
    public String findById(@PathVariable Long id){
       return  this.feignClient1.findById(id);
    }

    @GetMapping("/eurekaInfo/{servername}")
    public String getInfoFrimEureka(@PathVariable String servername){
        return this.feignClient2.getInfoFromEureka(servername);
    }

}
