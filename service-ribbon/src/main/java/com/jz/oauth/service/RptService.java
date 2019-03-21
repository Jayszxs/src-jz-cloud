package com.jz.oauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpAccessor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author jayszxs (jayszxs@outlook.com)
 * @date 2018/10/15 17:44
 */
@Service
public class RptService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SpringClientFactory factory;


    @Autowired
    private HttpAccessor httpAccessor;

    public String index() {
        //指定服务名
        /*ILoadBalancer lb =  factory.getLoadBalancer("SERVICE-RIBBON");
        List<Server> allServers = lb.getAllServers();
        List<Server> upServers = lb.getReachableServers();*/


        ClientHttpRequest clientHttpRequest = null;
        ClientHttpResponse clientHttpResponse = null;
        try {
            clientHttpRequest = httpAccessor.getRequestFactory().createRequest(new URI("http://rpt-web/rpt-web"),HttpMethod.GET);
            clientHttpResponse = clientHttpRequest.execute();

            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        URI expanded = restTemplate.getUriTemplateHandler().expand("http://rpt-web/login");
        System.out.println();
        return expanded.toString();
    }
}
