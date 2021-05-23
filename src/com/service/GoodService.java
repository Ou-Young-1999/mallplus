package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.GoodsDao;
import com.entity.Goods;

/**
 * 商品功能
 */
@Service	// 
@Transactional	// 
public class GoodService {

	@Autowired	
	private GoodsDao goodDao;
	//展示所有商品信息
	public List<Goods> getList(){
		return goodDao.getList();
	}
	
	//插入新商品
	public void insertGood(Goods good) {
		goodDao.insert(good);
	}

	//获取商品总数
	public int getTotal(){
		return goodDao.getTotal();
	}
	
	//依据名称查找商品
	public List<Goods> getListByName(String name){
		name = '%'+name+'%';
		return goodDao.getListByName(name);
	}
	
	//依据编号删除商品
	public void deleteGood(int id){
		goodDao.deleteById(id);
	}
	
	//依据编号查询商品
	public Goods queryGoodById(int id){
		return goodDao.getListById(id);
	}
	
	//依据类型查询商品
	public List<Goods> queryGoodByTypeId(int typeId){
		return goodDao.getListByTypeId(typeId);
	}
	
	//修改商品
	public void updateGood(Goods good){
		goodDao.updateById(good);
	}


}