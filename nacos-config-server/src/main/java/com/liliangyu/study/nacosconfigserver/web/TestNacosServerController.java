package com.liliangyu.study.nacosconfigserver.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liliangyu
 * @date 2019/7/24
 */
@RestController
@RefreshScope
@RequestMapping("/nacos")
public class TestNacosServerController {


    @Value("${color:false}")
    private Boolean useLocalCache;

    @GetMapping("/get")
    public Object getOne() {
        return useLocalCache;
    }
}
