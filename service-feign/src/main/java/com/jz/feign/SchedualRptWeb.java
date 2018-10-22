package com.jz.feign;


import com.jz.feign.impl.SchedualRptWebHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "rpt-web", fallback = SchedualRptWebHystric.class)
public interface SchedualRptWeb {

    @GetMapping("/rpt")
    void index();
}
