package com.jz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@SpringBootApplication
/**
 * EnableZuulProxy，开启zuul的功能
 */
@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
/**
 * 路由转发和过滤
 * @author Jayszxs
 */
public class ServiceZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceZuulApplication.class, args);
    }
}
