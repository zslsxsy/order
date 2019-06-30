package com.zsl.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: zsl
 * @Date 2019/6/9 11:35
 **/
@FeignClient(name ="product")
public interface ProductClient {

    @GetMapping("/msg")
    String productMsg();

}
