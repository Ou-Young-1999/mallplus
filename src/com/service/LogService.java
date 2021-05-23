package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.LogsDao;
import com.entity.Logs;

/**
 * 购物车记录
 */
@Service	// 
@Transactional	// 
public class LogService {
	@Autowired
	private LogsDao logDao;
	
	public List<Logs> getList(){//查找所有交易记录
		return logDao.getLogList();
	}
	
	//插入新购物车记录
	public void insertLog(Logs log) {
		logDao.insert(log);
	}

}
