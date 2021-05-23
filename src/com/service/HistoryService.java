package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.HistoriesDao;
import com.entity.Histories;

/**
 * ���ﳵ��¼
 */
@Service	// 
@Transactional	// 
public class HistoryService {
	@Autowired
	private HistoriesDao historyDao;
	
	public List<Histories> getList(){//�������н��׼�¼
		return historyDao.getHistoryList();
	}
	
	public List<Histories> getListById(int id){//�����û�id���ҽ��׼�¼
		return historyDao.getListById(id);
	}
	
	//�����¹��ﳵ��¼
	public void insertHistory(Histories history) {
		historyDao.insert(history);
	}

}
