package com.jz;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * consul服务提供者
 * 用于模仿注册
 *
 * @author Jayszxs (jayszxs@outlook.com)
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ConsultClientApplication {

    @RequestMapping("/")
    public String home() {
        return "Hello world";
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsultClientApplication.class, args);
    }
}
