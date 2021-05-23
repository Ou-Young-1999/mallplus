package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.entity.Items;

public interface ItemsDao {
    int deleteById(Integer id);//依据id删除购物车

    int insert(Items record);//新加入购物车

    int insertSelective(Items record);

    Items selectById(Integer id);

    int updateByIdSelective(Items record);

    int updateById(Items record);//修改购物车中记录   
    
    
	
	//依据商品编号和用户编号查询购物车
    @Select("select * from items where order_id=#{orderid} and good_id=#{goodid}")
	public Items getItemByTwoId(@Param("orderid")int orderid,@Param("goodid")int goodid);
    
    //依据用户编号查询购物车
    @Select("select * from items where order_id=#{orderid}")
	public List<Items> getItemListByOneId(@Param("orderid")int orderid);
    
    //查询所有购物车
    @Select("select * from items")
	public List<Items> getItemList();
}