package com.wk.cloud.microservicesimpleconsumermovie.controller;

import com.wk.cloud.microservicesimpleconsumermovie.entity.User;
import com.wk.cloud.microservicesimpleconsumermovie.feign.FeignClient;
import com.wk.cloud.microservicesimpleconsumermovie.feign.feignClient2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Autowired
    private FeignClient feignClient;

    @Autowired
    private feignClient2 feignClient2;

    @GetMapping("/findid/{id}")
    public String findById(@PathVariable Long id){
       return  this.feignClient.findById(id);
    }

    @GetMapping("/eurekaInfo/{servername}")
    public String getInfoFrimEureka(@PathVariable String servername){
        return this.feignClient2.getInfoFromEureka(servername);
    }

}
