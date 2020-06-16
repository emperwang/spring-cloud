package com.kai.service.impl;

import com.kai.entity.Payment;
import com.kai.mapper.PaymentMapper;
import com.kai.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public Payment getPaymentById(Long id) {

        return paymentMapper.getPaymentById(id);
    }

    @Override
    public int insertPayment(Payment payment) {
        int count = 0;
        count += paymentMapper.insertPayment(payment);
        return count;
    }
}
