package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.LogsDao;
import com.entity.Logs;

/**
 * ���ﳵ��¼
 */
@Service	// 
@Transactional	// 
public class LogService {
	@Autowired
	private LogsDao logDao;
	
	public List<Logs> getList(){//�������н��׼�¼
		return logDao.getLogList();
	}
	
	//�����¹��ﳵ��¼
	public void insertLog(Logs log) {
		logDao.insert(log);
	}

}
