package com.kai.service;

import cn.hutool.core.util.IdUtil;
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

    // 熔断操作
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  // 开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数阈值, 超过此阈值,也会进行熔断操作
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口,也就是说10s内访问此处超过上面定的熔断
                                                                                                // 或者在此时间窗口内错误的百分比 超过60% 熔断
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id){
        if (id < 0 ){
            throw new RuntimeException("*****id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return "线程 : - " + Thread.currentThread().getName()+"调用成功,流水号: "+ serialNumber;
    }

    public String paymentCircuitBreakerFallback(Integer id){

        return "id 不能为负数, 请稍候再试o(╥﹏╥)o , id="+id;
    }
}
