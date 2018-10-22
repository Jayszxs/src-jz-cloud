package com.jz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
/**
 * 启动一个服务注册中心
 */
@EnableEurekaServer

/**
 * 一个服务注册中心，用来管理服务节点
 * @author Jayszxs
 */
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
