package com.kai.service;

import com.kai.entity.CommonResult;
import com.kai.entity.Payment;

public class ConsumerPaymentServiceFallback implements ConsumerPaymentService {
    @Override
    public CommonResult<Payment> getById(Long id) {

        return new CommonResult<>(444,"fallback return: " + id);
    }

    @Override
    public Object creatPayment(Payment payment) {
        return new CommonResult<>(444,"fallback return: " + payment.toString());
    }

    @Override
    public Object paymentTimeout() {
        return new CommonResult<>(444,"payment timeout fallback");
    }
}
