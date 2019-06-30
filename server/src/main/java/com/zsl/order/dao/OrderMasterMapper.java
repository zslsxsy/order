package com.zsl.order.dao;

import com.zsl.order.entity.OrderMaster;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMasterMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(OrderMaster record);

    int insertSelective(OrderMaster record);

    OrderMaster selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(OrderMaster record);

    int updateByPrimaryKey(OrderMaster record);
}