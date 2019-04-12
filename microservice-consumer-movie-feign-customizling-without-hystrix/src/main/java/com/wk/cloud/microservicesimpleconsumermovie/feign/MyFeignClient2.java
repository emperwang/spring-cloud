package com.wk.cloud.microservicesimpleconsumermovie.feign;

import com.wk.cloud.config.feignConfig2;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="xxxx",url = "http://localhost:8761",configuration = feignConfig2.class)
public interface MyFeignClient2 {

    @RequestMapping(value = "/eureka/apps/{servername}",method = RequestMethod.GET)
    public String getInfoFromEureka(@PathVariable("servername") String servername);
}
