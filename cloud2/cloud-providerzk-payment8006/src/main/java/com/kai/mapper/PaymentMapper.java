package com.kai.mapper;

import com.kai.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper {
    Payment getPaymentById(@Param("id") Long id);

    int insertPayment(Payment payment);
}
