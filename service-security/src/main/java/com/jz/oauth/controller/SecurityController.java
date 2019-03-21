package com.jz.oauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jayszxs (jayszxs7@gmail.com)
 * @date 2019/3/14
 */
@RestController
public class SecurityController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
