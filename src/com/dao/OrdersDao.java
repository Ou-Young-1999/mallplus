package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.entity.Orders;

public interface OrdersDao {
    int deleteById(Integer id);

    int insert(Orders record);//插入新购买记录

    int insertSelective(Orders record);

    Orders selectById(Integer id);

    int updateByIdSelective(Orders record);

    int updateById(Orders record);  
    
    /**
     * 查找所有交易记录
     */
    @Select("select * from orders order by id")
    public List<Orders> getList();
    
    /**
     * 依据用户id查找交易记录
     */
    @Select("select * from orders where user_id=#{userId}")
    public List<Orders> getListById(@Param("userId")int userId);

}