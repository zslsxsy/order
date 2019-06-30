package com.zsl.order.exception;

import com.zsl.order.enums.ResultEnum;

/**
 * @Author: zsl
 * @Date 2019/6/30 0:15
 **/
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code,String message){
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
