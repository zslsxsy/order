package com.zsl.order.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zsl.order.dto.OrderDto;
import com.zsl.order.entity.OrderDetail;
import com.zsl.order.enums.ResultEnum;
import com.zsl.order.exception.OrderException;
import com.zsl.order.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zsl
 * @Date 2019/6/30 0:30
 **/
@Slf4j
public class OrderForm2OrderDto {

    public static OrderDto convert(OrderForm orderForm){
        OrderDto orderDto = new OrderDto();
        orderDto.setBuyerName(orderForm.getName());
        orderDto.setBuyerPhone(orderForm.getPhone());
        orderDto.setBuyerAddress(orderForm.getAddress());
        orderDto.setBuyerOpenid(orderForm.getOpenid());
        List<OrderDetail> orderDetails = new ArrayList<>();
        Gson gson = new Gson();
        try {
            gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        }catch (Exception e){
            log.error("【json转换错误，String={}",orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        return null;
    }
}
