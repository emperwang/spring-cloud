package com.kai.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping(value = "/configclient/getinfo")
    public String getConfigInfo(){
        log.info("into getConfiginfo : "+ configInfo);
        return configInfo;
    }
}
