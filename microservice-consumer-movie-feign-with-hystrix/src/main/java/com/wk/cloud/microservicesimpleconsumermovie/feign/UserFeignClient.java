package com.wk.cloud.microservicesimpleconsumermovie.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 这里的fallback就是feign的断路函数,当访问不成功时,就会调用整个fallback函数
 */
@FeignClient(name = "microservice-provide-user",fallback = feignFallback.class)
public interface UserFeignClient {

    /**
     * 注意:1,这里虽然也是使用的springmvc的注解,但是类似GetMapping和PostMapping这样的注解时不支持的
     * 2,接收的参数时复杂对象,即使设置了get请求,feign依然使用的是post请求
     * 3,pathVariable注解必须设置value值
     */
    @RequestMapping(value = "/find/{id}",method = RequestMethod.GET)
    public String findById(@PathVariable(value = "id") Long id);

}