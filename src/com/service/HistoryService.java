package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.HistoriesDao;
import com.entity.Histories;

/**
 * 购物车记录
 */
@Service	// 
@Transactional	// 
public class HistoryService {
	@Autowired
	private HistoriesDao historyDao;
	
	public List<Histories> getList(){//查找所有交易记录
		return historyDao.getHistoryList();
	}
	
	public List<Histories> getListById(int id){//按照用户id查找交易记录
		return historyDao.getListById(id);
	}
	
	//插入新购物车记录
	public void insertHistory(Histories history) {
		historyDao.insert(history);
	}

}
