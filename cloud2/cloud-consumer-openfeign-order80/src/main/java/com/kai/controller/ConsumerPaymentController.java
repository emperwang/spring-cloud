package com.kai.controller;

import com.kai.service.ConsumerPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class ConsumerPaymentController {

    @Resource
    private ConsumerPaymentService paymentService;

    @GetMapping(value = "/consumer/payment/{id}")
    public Object getPaymentById(@PathVariable(name = "id") Long id){

        return paymentService.getById(id);
    }

    @GetMapping(value = "/consumer/payment/timeout")
    public Object getPaymentTimeout(){

        return paymentService.paymentTimeout();
    }

}
