package com.zsl.order.dto;

import com.zsl.order.entity.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: zsl
 * @Date 2019/6/8 23:52
 **/
@Data
public class OrderDto {

    /** 订单id. */
    private String orderId;

    /** 买家名字. */
    private String buyerName;

    /** 买家手机号. */
    private String buyerPhone;

    /** 买家地址. */
    private String buyerAddress;

    /** 买家微信Openid. */
    private String buyerOpenid;

    /** 订单总金额. */
    private BigDecimal orderAmount;

    /** 订单状态, 默认为0新下单. */
    private Integer orderStatus;

    /** 支付状态, 默认为0未支付. */
    private Integer payStatus;

    private List<OrderDetail> orderDetailList;
}
