package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.entity.Histories;

public interface HistoriesDao {
	
    int insert(Histories record);//新加入购物车
    
    @Select("select * from histories order by id")
	public List<Histories> getHistoryList();   
    
    /**
     * 依据用户id查找交易记录
     */
    @Select("select * from histories where user_id=#{userId}")
    public List<Histories> getListById(@Param("userId")int userId);
}
