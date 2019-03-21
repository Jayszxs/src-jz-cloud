package com.jz.oauth.controller;

import com.jz.feign.SchedualServiceHi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 定义消费入口
 * @author jayszxs (jayszxs@outlook.com)
 * @date 2018/10/10 10:53
 */
@RestController
public class HiController {

    @Resource
    private SchedualServiceHi schedualServiceHi;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        String url = schedualServiceHi.sayHiFromClientOne(name);
        return url;
    }
}
