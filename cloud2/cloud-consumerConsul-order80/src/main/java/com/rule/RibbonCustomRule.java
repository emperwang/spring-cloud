package com.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonCustomRule {
    // 定制ribbon的负载算法; 此处使用已定义的随机算法
    @Bean
    public IRule getRule(){
        return new RandomRule();
    }
}
