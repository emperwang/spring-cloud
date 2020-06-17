package com.kai.controller;

import com.kai.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable(name = "id") Integer id){
        String result = paymentService.payemntInfoOk(id);
        log.info("*********paymentInfoOk: result: "+ result+"; port = "+serverPort);
        return result+"; port = "+serverPort;
    }

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable(name = "id") Integer id){
        String res = paymentService.paymentInfoTimeout(id);
        log.info("********paymentInfoTimeout, result: " + res+"; port = "+serverPort);
        return res +"; port = "+serverPort;
    }

    @GetMapping(value = "/payment/hystrix/breaker/{id}")
    public String paymentCircuitBreaker(@PathVariable(name = "id") Integer id){
        String res = paymentService.paymentCircuitBreaker(id);
        log.info("********paymentCircuitBreaker, result: " + res+"; port = "+serverPort);
        return res;
    }
}
