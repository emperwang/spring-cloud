package com.kai.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
// 次注解是打开 自动刷新配置; 不过仍需要人为触发, 发出命令: curl -X POST http://localhost:3355/actuator/refresh
// 此 actuator/refresh 需要暴露出去, 在配置文件中配置
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping(value = "/configclient/getinfo")
    public String getConfigInfo(){
        log.info("into getConfiginfo : "+ configInfo);
        return configInfo;
    }
}
