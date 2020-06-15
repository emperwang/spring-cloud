package com.kai.mapper;

import com.kai.entity.Payment;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PaymentMapperTest {

    @Autowired
    PaymentMapper paymentMapper;

    @Test
    public void insertAndGet(){
        Assertions.assertThat(paymentMapper).isNotNull();
        Payment payment = new Payment();
        payment.setSerial("123456");
        paymentMapper.insertPayment(payment);
    }


    @Test
    public void getById(){
        Assertions.assertThat(this.paymentMapper).isNotNull();
        Payment paymentById = paymentMapper.getPaymentById(1L);
        System.out.println(paymentById);
    }
}
