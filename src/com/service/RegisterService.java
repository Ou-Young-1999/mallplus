package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.RegistersDao;
import com.entity.Registers;

/**
 * ���ﳵ��¼
 */
@Service	// 
@Transactional	// 
public class RegisterService {
	@Autowired
	private RegistersDao registerDao;
	
	public List<Registers> getList(){//�������н��׼�¼
		return registerDao.getRegisterList();
	}
	
	//�����¹��ﳵ��¼
	public void insertRegister(Registers register) {
		registerDao.insert(register);
	}

}
