package com.jz.oauth.controller;

import com.jz.oauth.service.RptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Random;

/**
 * 对非spring boot项目增加分布式 -》 在eureka做注册于发现，ribbon负载均衡，但是返回的为一个modelandview
 *  所以只是使用ribbon来获取eureka中的项目地址，做随机重定向。
 * @author jayszxs (jayszxs@outlook.com)
 * @date 2018/10/15 17:44
 */
@Controller
public class RptController {

    @Autowired
    private RptService rptService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/rpt-web")
    public ModelAndView index() {

        List<ServiceInstance> list = discoveryClient.getInstances("RPT-WEB");
        if(!list.isEmpty()) {
            int i = new Random().nextInt(list.size());
            String url = list.get(i).getUri().toString();

            System.out.println(url);


            ModelAndView modelAndView = new ModelAndView("redirect:"+ url +"/rpt-web");
            return modelAndView;
        }
        return null;
    }

    @GetMapping(value = "/getInfo")
    @ResponseBody
    public String getInfo() {
        //List<ServiceInstance> list = discoveryClient.getInstances("RPT-WEB");
        System.out.println("discoveryClient.getServices().size() = " + discoveryClient.getServices().size());

        StringBuffer stringBuffer = new StringBuffer();
        for( String s :  discoveryClient.getServices()){
            System.out.println("services " + s);
            List<ServiceInstance> serviceInstances =  discoveryClient.getInstances(s);
            for(ServiceInstance si : serviceInstances){
                stringBuffer.append("    services:" + s + ":getHost()=" + si.getHost());
                stringBuffer.append("\n");
                stringBuffer.append("    services:" + s + ":getPort()=" + si.getPort());
                stringBuffer.append("\n");
                stringBuffer.append("    services:" + s + ":getServiceId()=" + si.getServiceId());
                stringBuffer.append("\n");
                stringBuffer.append("    services:" + s + ":getUri()=" + si.getUri());
                stringBuffer.append("\n");
                stringBuffer.append("    services:" + s + ":getMetadata()=" + si.getMetadata());
                stringBuffer.append("\n");
                stringBuffer.append("    services:" + s + ":getScheme()=" + si.getScheme());
                stringBuffer.append("\n");

                System.out.println("    services:" + s + ":getHost()=" + si.getHost());
                System.out.println("    services:" + s + ":getPort()=" + si.getPort());
                System.out.println("    services:" + s + ":getServiceId()=" + si.getServiceId());
                System.out.println("    services:" + s + ":getUri()=" + si.getUri());
                System.out.println("    services:" + s + ":getMetadata()=" + si.getMetadata());
                System.out.println("    services:" + s + ":getScheme()=" + si.getScheme());
                System.out.println();
            }
        }
       return "ok";
    }
}
