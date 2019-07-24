package com.liliangyu.study.configclient.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liliangyu
 * @date 2019/7/24
 */
@RestController
public class TestConfigController {


    @Value("${color}")
    private String color;

    @GetMapping("/color")
    public Object getOne() {
        return color;
    }
}
