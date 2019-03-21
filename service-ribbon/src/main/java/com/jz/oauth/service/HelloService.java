package com.jz.oauth.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author jayszxs (jayszxs@outlook.com)
 * @date 2018/10/9 18:51
 */
@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        String url = restTemplate.getForObject("http://SERVICE-HI/hi?name="+name, String.class);
        return url;
    }

    public String hiError(String name) {
        return "hi " + name + ", sorry, error!!";
    }
}
