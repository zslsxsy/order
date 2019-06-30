package com.zsl.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: zsl
 * @Date 2019/6/8 23:56
 **/
@RestController
@Slf4j
public class ClientController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getProduct")
    public String getMsg(){
        //第一种方式(直接用restTemplate)
        /*RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("http://127.0.0.1:8080/msg",String.class);*/
        //第二种方式(利用loadBalance通过应用获取url)
        RestTemplate restTemplate = new RestTemplate();
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        String url = String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort())+"msg";
        String response = restTemplate.getForObject(url,String.class);

        //第三种方式：
//        String response = restTemplate.getForObject("http://PRODUCT/msg",String.class);
        log.info("response={}",response);
        return response;
    }
}
