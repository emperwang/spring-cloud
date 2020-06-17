package com.kai.controller;

import com.kai.service.ConsumerFeignHystrixServer;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
// 统一配置 hystrix 的fallback方法
@DefaultProperties(defaultFallback = "paymnetGlobalFallback")
public class ConsumerHystrixController {

    @Resource
    private ConsumerFeignHystrixServer consumerFeignHystrixServer;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable(name = "id") Integer id){
        String s = consumerFeignHystrixServer.paymentInfoOk(id);
        return s;
    }

    // 断路器 保护  HystrixCommandProperties 配置文件
    // 此方式,为每一个方法配置一个fallback方法,看似很方便,真实情况是 方法爆炸,太多;
    // 其实只需要给特定的方法添加fallback,其他方法可以使用默认的fallback
    /*@HystrixCommand(fallbackMethod = "paymentInfoTimeoutFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")  // 1.5s内为正常
    })*/
    //@HystrixCommand  // 使用默认的fallback
    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable(name = "id") Integer id){
        return consumerFeignHystrixServer.paymentInfoTimeout(id);
    }
    // fallback 要和原方法的返回值 参数类型一致
    //
    public String paymentInfoTimeoutFallback(@PathVariable(name = "id") Integer id){
        return "This is consumer hystrix openfeign, system is busy, please try again later";
    }

    public String paymnetGlobalFallback(){
        return "Global fallback saying, system is busy, please try again later";
    }
}
