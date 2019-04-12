package com.wk.cloud.microservicesimpleconsumermovie.feign;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.wk.cloud.microservicesimpleconsumermovie.entity.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class UserFeignFallbackFactory implements FallbackFactory<UserFeignClient> {
    @Override
    public UserFeignClient create(Throwable throwable) {
        System.out.println("feign fallback fail season:"+throwable.getMessage());
        return new UserFeignClientFallback() {
            @Override
            public String findById(Long id) {
                User user = new User();
                user.setId(-1L);
                return user.toString();
            }
        };
    }
}
