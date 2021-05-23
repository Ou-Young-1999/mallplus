package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import com.entity.Registers;

public interface RegistersDao {
	
    int insert(Registers record);//新加入购物车
    
    @Select("select * from registers order by id")
	public List<Registers> getRegisterList();

}
