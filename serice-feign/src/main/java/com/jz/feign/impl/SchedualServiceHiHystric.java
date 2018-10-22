package com.jz.feign.impl;

import com.jz.feign.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * 服务不通时的错误处理对象
 * @author jayszxs (jayszxs@outlook.com)
 * @date 2018/10/10 15:06
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry! " + name;
    }
}
