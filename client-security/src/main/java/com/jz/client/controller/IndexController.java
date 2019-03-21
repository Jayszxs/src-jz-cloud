package com.jz.client.controller;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jayszxs (jayszxs7@gmail.com)
 * @date 2019/3/21
 */
@Controller
public class IndexController {

    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/")
    @ResponseBody
    public String index(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String code = request.getParameter("code");
        if(code != null && !"".equals(code)) {
            String url = "http://127.0.0.1:9001/oauth/token";
            String data = "grant_type=authorization_code&redirect_uri=http://localhost:9002&client_id=test&client_secret=test&code="+code;
            String result = sendPost(url+"?"+data);
            return result;
        } else {
            String clientId = "test";
            String redirectUri = "http://localhost:9002";
            String url = "http://localhost:9001/oauth/authorize?response_type=code&client_id="+clientId+"&redirect_uri="+redirectUri;
            response.sendRedirect(url);
            return "";
        }
    }


    /**
     * post请求方法
     */
    public  String sendPost(String url) {
        String response = null;
        log.info("url: " + url);
        try {
            CloseableHttpClient httpClient = null;
            CloseableHttpResponse httpResponse = null;
            try {
                httpClient = HttpClients.createDefault();
                HttpPost httppost = new HttpPost(url);
                httpResponse = httpClient.execute(httppost);
                response = EntityUtils
                        .toString(httpResponse.getEntity());
                log.info("response: " + response);
            } finally {
                if (httpClient != null) {
                    httpClient.close();
                }
                if (httpResponse != null) {
                    httpResponse.close();
                }
            }
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
        }
        return response;
    }
}
