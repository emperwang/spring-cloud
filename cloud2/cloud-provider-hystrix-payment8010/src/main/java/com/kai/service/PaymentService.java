package com.kai.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String payemntInfoOk(Integer id){
        return "线程 : - " + Thread.currentThread().getName()+" payemntInfoOk- id: " +id;
    }

    // HystrixCollapserProperties
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")  // 处理时间在3s内
    })
    public String paymentInfoTimeout(Integer id){
        int timeNumber = 5;
        try{
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程 : - " + Thread.currentThread().getName()+" paymentInfoTimeout- id: " +id;
    }

    public String paymentInfoTimeoutFallback(Integer id){
        return "线程 : - " + Thread.currentThread().getName()+"系统繁忙,请稍后再试..";
    }
}
