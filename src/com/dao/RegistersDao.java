package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import com.entity.Registers;

public interface RegistersDao {
	
    int insert(Registers record);//�¼��빺�ﳵ
    
    @Select("select * from registers order by id")
	public List<Registers> getRegisterList();

}
