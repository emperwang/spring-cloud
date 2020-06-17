package com.kai.service;

import com.kai.entity.CommonResult;
import com.kai.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// fallback = 设置兜底 也就是处异常时的回调
// 此处可以使用具体类来实现此接口 作为 异常回调
@FeignClient(value = "cloud-payment-service", fallback = ConsumerPaymentServiceFallback.class)
public interface ConsumerPaymentService {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getById(@PathVariable(name = "id") Long id);

    @PostMapping(value = "/payment/create")
    public Object creatPayment(@RequestBody Payment payment);

    @GetMapping(value = "/payment/timeout")
    public Object paymentTimeout();
}
