package com.kai.service;

import org.springframework.stereotype.Component;

// 此类可以作为feign的方法降级
@Component
public class ConsumerFeignHystrixPaymentFallback implements ConsumerFeignHystrixServer {
    @Override
    public String paymentInfoOk(Integer id) {
        return "线程 :" + Thread.currentThread().getName()+ "paymentInfoOk fallback.";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "线程 :" + Thread.currentThread().getName()+ "paymentInfoTimeout fallback.";
    }
}
