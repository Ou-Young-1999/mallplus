package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ItemsDao;
import com.entity.Items;

/**
 * 购物车记录
 */
@Service	// 
@Transactional	// 
public class ItemService {
	@Autowired
	private ItemsDao itemDao;
	
	//依据用户id展示所有购物车信息
	public List<Items> getItemListByOneId(int orderid){
		return itemDao.getItemListByOneId(orderid);
	}
	
	//依据用户id和商品id展示所有购物车信息
	public Items getItemByTwoId(int orderid,int goodid){
		return itemDao.getItemByTwoId(orderid,goodid);
	}
	
	//插入新购物车记录
	public void insertItem(Items item) {
		itemDao.insert(item);
	}
	
	//依据编号删除购物车记录
	public void deleteItem(int id){
		itemDao.deleteById(id);
	}
	
	//修改购物车记录
	public void updateItem(Items item){
		itemDao.updateById(item);
	}

}
