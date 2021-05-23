package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.OrdersDao;
import com.entity.Orders;

/**
 * 交易记录
 */
@Service
@Transactional
public class OrderService {

	@Autowired
	private OrdersDao orderDao;
	
	public void insert(Orders order) {
		orderDao.insert(order);
	}
	
	public List<Orders> getListById(int id){//按照用户id查找交易记录
		return orderDao.getListById(id);
	}
	
	public List<Orders> getList(){//查找所有交易记录
		return orderDao.getList();
	}
	

}
