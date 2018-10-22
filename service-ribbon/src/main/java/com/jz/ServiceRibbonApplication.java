package com.jz;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
/**
 * 通过@EnableDiscoveryClient向服务中心注册
 */
@EnableEurekaClient
/**
 * 其实用更简单的话来说，就是如果选用的注册中心是eureka，那么就推荐@EnableEurekaClient，如果是其他的注册中心，那么推荐使用@EnableDiscoveryClient
 */
@EnableDiscoveryClient
/**
 * 开启断路器
 */
@EnableHystrix

/**
 * 服务于消费者 ribbon 用来负载均衡
 * @author Jayszxs
 */
public class ServiceRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run( ServiceRibbonApplication.class, args );
    }

    @Bean
    /**
     * @LoadBalanced注解表明这个restRemplate开启负载均衡的功能
     */
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}