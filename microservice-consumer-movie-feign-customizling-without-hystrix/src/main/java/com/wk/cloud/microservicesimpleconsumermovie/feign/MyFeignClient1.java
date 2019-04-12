package com.wk.cloud.microservicesimpleconsumermovie.feign;

import com.wk.cloud.config.feignConfig;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "microservice-provide-user",configuration = feignConfig.class,fallback = feignFallback.class)
public interface MyFeignClient1 {

    /**
     * 注意:1,这里虽然也是使用的springmvc的注解,但是类似GetMapping和PostMapping这样的注解时不支持的
     * 2,接收的参数时复杂对象,即使设置了get请求,feign依然使用的是post请求
     * 3,pathVariable注解必须设置value值
     */
/*    @RequestMapping(value = "/find/{id}",method = RequestMethod.GET)
    public String findById(@PathVariable(value = "id") Long id);*/

    @RequestLine(value = "GET /find/{id}")
    public String findById(@Param("id") Long id);
}
