package com.wk.cloud.microservicesimpleprovideruser.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.wk.cloud.microservicesimpleprovideruser.entity.User;
import com.wk.cloud.microservicesimpleprovideruser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/instances")
    public String serviceUrl(){
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("MICROSERVICE-PROVIDE-USER", false);
        return instance.getHomePageUrl();
    }

    @GetMapping("/instanceInfo")
    public String instanceInfo(){
        ServiceInstance localServiceInstance = discoveryClient.getLocalServiceInstance();
        return localServiceInstance.getServiceId()+localServiceInstance.getPort();
    }

    @GetMapping(value = "/find/{id}")
    public User findById(@PathVariable  Long id){
        return userRepository.getOne(id);
    }

    @GetMapping("/test.do")
    public String test(){
        return "ok....";
    }
}
