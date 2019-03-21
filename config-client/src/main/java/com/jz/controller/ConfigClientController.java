package com.jz.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 访问配置文件中心 实例
 *  配置文件中心: config-service
 * @author jayszxs (jayszxs@outlook.com)
 * @date 2018/10/22 16:39
 */
@RestController
public class ConfigClientController {

    @Value("${foo}")
    private String foo;
    @Value("${democonfigclient.message}")
    private String ss;


    @GetMapping(value = {"/hi"})
    public String hi() {
        return foo + " ----- " + ss;
    }
}
