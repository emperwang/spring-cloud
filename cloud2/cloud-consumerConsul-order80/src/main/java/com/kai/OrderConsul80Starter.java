package com.kai;

import com.rule.RibbonCustomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient
// 此处表示: ribbon访问服务cloud-providerconsul-payment时,使用定制的负载均衡算法RibbonCustomRule
@RibbonClient(name = "cloud-providerconsul-payment", configuration = RibbonCustomRule.class)
public class OrderConsul80Starter {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsul80Starter.class, args);
    }
}
