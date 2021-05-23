package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.entity.Goods;

public interface GoodsDao {
    int deleteById(Integer id);//删除商品   

    int insert(Goods record);//新加商品

    int insertSelective(Goods record);

    Goods selectById(Integer id);

    int updateByIdSelective(Goods record);

    int updateById(Goods record);//修改商品
    
    
	/**
	 * 获取所有商品信息
	 * @return
	 */
    @Select("select * from goods order by id asc")
	public List<Goods> getList();
	
	/**
	 * 获取所有商品数量
	 * @return
	 */
    @Select("select count(*) from goods")
	public int getTotal();
	
	/**
	 * 依据名称查找商品
	 * @param name
	 * @return
	 */
    @Select("select * from goods where name like #{name} order by id asc")
	public List<Goods> getListByName(@Param("name")String name);
    
	/**
	 * 依据编号查找商品
	 * @param id
	 * @return
	 */
    @Select("select * from goods where id = #{id}")
	public Goods getListById(@Param("id")int id);
    
	/**
	 * 依据类型查找商品
	 * @param typeId
	 * @return
	 */
    @Select("select * from goods where type_id = #{typeId}")
	public List<Goods> getListByTypeId(@Param("typeId")int typeId);
}