package com.kai.config.ribbon;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

//
public interface LoadBalancer {
    // 收集总共有多少台能够提供服务的机器, 并放到list里面
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
