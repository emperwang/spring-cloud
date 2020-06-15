package com.kai.controller;

import com.kai.entity.CommonResult;
import com.kai.entity.Payment;
import com.kai.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private Integer port;

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getById(@PathVariable(name = "id") Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        if (paymentById != null){
            return new CommonResult<Payment>(200, "ok, port="+port, paymentById);
        }else{
            return new CommonResult<Payment>(404, "not found, port="+port, null);
        }
    }

    @PostMapping(value = "/payment/create", consumes = "application/json")
    public Object creatPayment(@RequestBody Payment payment){
        int i = paymentService.insertPayment(payment);
        if (i > 0){
            return new CommonResult<Payment>(200, "创建成功, port="+port,null);
        }else{
            return new CommonResult<Payment>(500, "创建失败, port="+port, null);
        }
    }
}
