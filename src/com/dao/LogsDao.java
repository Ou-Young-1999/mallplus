package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.entity.Logs;

public interface LogsDao {
	
    int insert(Logs record);//新加入购物车
    
    @Select("select * from logs order by id")
	public List<Logs> getLogList();

}
