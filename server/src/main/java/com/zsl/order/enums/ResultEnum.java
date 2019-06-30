package com.zsl.order.enums;

import lombok.Getter;

/**
 * @Author: zsl
 * @Date 2019/6/30 0:25
 **/
@Getter
public enum ResultEnum {
    PARAM_ERROR(1,"参数错误"),;

    private Integer code;

    private String message;

    ResultEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
