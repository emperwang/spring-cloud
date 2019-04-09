package com.wk.cloud.microservicesimpleprovideruser.controller;

import com.wk.cloud.microservicesimpleprovideruser.entity.User;
import com.wk.cloud.microservicesimpleprovideruser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/find/{id}")
    public User findById(@PathVariable  Long id){
        return userRepository.getOne(id);
    }

    @GetMapping("/test.do")
    public String test(){
        return "ok....";
    }
}
