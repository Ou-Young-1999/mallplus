package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.AdminsDao;
import com.entity.Admins;

/**
 * 管理员
 */
@Service	// 
@Transactional	// 
public class AdminService {

	@Autowired
	private AdminsDao adminDao;
	
	
	/**
	 * 登录检查
	 */
	public boolean checkUser(String username, String password){
		return adminDao.getByUsernameAndPassword(username, password) != null;
	}
	
	/**
	 * 登录检查
	 */
	public void update(Admins admin){
		 adminDao.updateById(admin);
	}
	
}
