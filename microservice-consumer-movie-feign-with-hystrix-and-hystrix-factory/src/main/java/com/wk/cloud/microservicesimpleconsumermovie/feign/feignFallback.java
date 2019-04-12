package com.wk.cloud.microservicesimpleconsumermovie.feign;

import com.wk.cloud.microservicesimpleconsumermovie.entity.User;
import org.springframework.stereotype.Component;

/**
 * 当在controller注入feiclient时,发现有两个bean,不知注入那个,可以在这个实现类上写上component的value值
 * 相当于给其生成了一个别名,这样注入就不会混淆了.
 */
//@Component(value = "feignFallback")
@Component
public class feignFallback implements UserFeignClient {

    @Override
    public String findById(Long id) {
        User user = new User();
        user.setId(0L);
        return user.toString();
    }
}
