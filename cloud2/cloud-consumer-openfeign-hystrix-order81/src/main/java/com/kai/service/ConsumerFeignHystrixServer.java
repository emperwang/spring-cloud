package com.kai.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "provider-hystrix-payment8010", fallback = ConsumerFeignHystrixPaymentFallback.class)
public interface ConsumerFeignHystrixServer {

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable(name = "id") Integer id);

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable(name = "id") Integer id);
}
