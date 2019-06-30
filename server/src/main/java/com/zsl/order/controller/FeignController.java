package com.zsl.order.controller;

import com.zsl.order.client.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zsl
 * @Date 2019/6/9 11:37
 **/
@RestController
@Slf4j
public class FeignController {
    @Autowired
    private ProductClient productClient;
    @GetMapping("/getMsg")
    public String getMsg(){
        String response = productClient.productMsg();
        log.info("response={}",response);
        return response;

    }

}
