package com.kai.controller;


import com.kai.config.ribbon.LoadBalancer;
import com.kai.config.ribbon.MyLoadBalance;
import com.kai.entity.CommonResult;
import com.kai.entity.Payment;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class OrderController {

    private String LocalPaymentUrl="http://localhost:8001";

    // restTemplate 添加注解@LoadBalanced 就可以使用eureka中的服务的名字来进行访问,并且有负载均衡的功能
    private String InstanceName = "cloud-providerconsul-payment";
    private String LocalPaymentHostName="http://"+InstanceName;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public Object getOrder(@PathVariable(name = "id") Long id){
        /*ResponseEntity<Payment> entity = restTemplate.getForEntity(LocalPaymentUrl + "/payment/get/" + id,
                Payment.class);
        int statusCode = entity.getStatusCode().value();
        if (statusCode == 200 || statusCode == 201){
            return new CommonResult<Payment>(statusCode, "ok", entity.getBody());
        }else{
            return new CommonResult<Payment>(statusCode, "error", null);
        }*/
        ResponseEntity<CommonResult> responseEntity = restTemplate.getForEntity(LocalPaymentHostName + "/payment/get/" + id,
                CommonResult.class);
        return responseEntity.getBody();
    }

    @PostMapping(value = "/consumer/payment/create")
    public Object getOrder(@RequestBody Payment payment){
        ResponseEntity<CommonResult> responseEntity = restTemplate.postForEntity(LocalPaymentHostName + "/payment/create", payment, CommonResult.class);
        return responseEntity.getBody();
    }

    @GetMapping(value = "/consumer/payment/lb/{id}")
    public Object LbGetOrder(@PathVariable(name = "id") Long id){
        // 获取所有此name对应的可用的服务
        // 并随机查找一个
        List<ServiceInstance> services = discoveryClient.getInstances(this.InstanceName);
        ServiceInstance instances = loadBalancer.instances(services);

        ResponseEntity<CommonResult> responseEntity = restTemplate.getForEntity(instances.getUri() + "/payment/get/" + id,
                CommonResult.class);
        return responseEntity.getBody();
    }
}
