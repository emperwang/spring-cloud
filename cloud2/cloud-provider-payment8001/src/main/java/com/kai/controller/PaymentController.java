package com.kai.controller;

import com.kai.entity.CommonResult;
import com.kai.entity.Payment;
import com.kai.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private Integer port;

    /**
     * 通过  discoveryClient可以去发现eureka上的服务信息
     */
    @GetMapping(value = "/payment/discover")
    public Object discoverPayment(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println("service: " + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            System.out.println("instance: port="+instance.getHost()+", instance-id="+instance.getInstanceId()+
                    ", schema="+instance.getScheme()+", serviceId="+instance.getServiceId()+
                    ",uri=" + instance.getUri());
        }

        return "ok";
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getById(@PathVariable(name = "id") Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        if (paymentById != null){
            return new CommonResult<Payment>(200, "ok, port="+port, paymentById);
        }else{
            return new CommonResult<Payment>(404, "not found, port="+port, null);
        }
    }

    @PostMapping(value = "/payment/create", consumes = "application/json")
    public Object creatPayment(@RequestBody Payment payment){
        int i = paymentService.insertPayment(payment);
        if (i > 0){
            return new CommonResult<Payment>(200, "创建成功, port="+port,null);
        }else{
            return new CommonResult<Payment>(500, "创建失败, port="+port, null);
        }
    }
}
