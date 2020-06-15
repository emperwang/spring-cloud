package com.kai.service;

import com.kai.entity.Payment;

public interface PaymentService {
    Payment getPaymentById(Long id);
    int insertPayment(Payment payment);
}
