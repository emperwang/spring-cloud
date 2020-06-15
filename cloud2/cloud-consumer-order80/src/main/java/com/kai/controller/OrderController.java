package com.kai.controller;


import com.kai.entity.CommonResult;
import com.kai.entity.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

    private String LocalPaymentUrl="http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public Object getOrder(@PathVariable(name = "id") Long id){
        /*ResponseEntity<Payment> entity = restTemplate.getForEntity(LocalPaymentUrl + "/payment/get/" + id,
                Payment.class);
        int statusCode = entity.getStatusCode().value();
        if (statusCode == 200 || statusCode == 201){
            return new CommonResult<Payment>(statusCode, "ok", entity.getBody());
        }else{
            return new CommonResult<Payment>(statusCode, "error", null);
        }*/
        ResponseEntity<CommonResult> responseEntity = restTemplate.getForEntity(LocalPaymentUrl + "/payment/get/" + id,
                CommonResult.class);
        return responseEntity.getBody();
    }

    @PostMapping(value = "/consumer/payment/create")
    public Object getOrder(@RequestBody Payment payment){
        ResponseEntity<CommonResult> responseEntity = restTemplate.postForEntity(LocalPaymentUrl + "/payment/create", payment, CommonResult.class);
        return responseEntity.getBody();
    }
}
