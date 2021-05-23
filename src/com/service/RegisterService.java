package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.RegistersDao;
import com.entity.Registers;

/**
 * 购物车记录
 */
@Service	// 
@Transactional	// 
public class RegisterService {
	@Autowired
	private RegistersDao registerDao;
	
	public List<Registers> getList(){//查找所有交易记录
		return registerDao.getRegisterList();
	}
	
	//插入新购物车记录
	public void insertRegister(Registers register) {
		registerDao.insert(register);
	}

}
