package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.entity.Histories;

public interface HistoriesDao {
	
    int insert(Histories record);//�¼��빺�ﳵ
    
    @Select("select * from histories order by id")
	public List<Histories> getHistoryList();   
    
    /**
     * �����û�id���ҽ��׼�¼
     */
    @Select("select * from histories where user_id=#{userId}")
    public List<Histories> getListById(@Param("userId")int userId);
}
