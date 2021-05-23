package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UsersDao;
import com.entity.Users;

/**
 * 用户功能
 */
@Service	// 
@Transactional	// 
public class UserService {

	@Autowired		//spring娉ㄥ叆绫诲璞�
	private UsersDao userDao;
	
	/**
	 * 用户登录验证账号密码
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean checkUser(String username, String password){
		return userDao.getByUsernameAndPassword(username, password) != null;
	}
	
	//展示所有用戶信息
	public List<Users> getList(){
		return userDao.getList();
	}
	
	//插入新用戶
	public int insertUser(Users user) {
		if(userDao.isExist(user.getUsername())==null) {
			userDao.insert(user);
			return 1;
		}else {
			return 0;
		}
		
	}

	//获取用戶总数
	public int getTotal(){
		return userDao.getTotal();
	}
	
	//依据名称查找用戶
	public List<Users> getListByName(String username){
		return userDao.getListByName(username);
	}
	
	//依据名称准确查找用戶
	public Users selectByUsername(String username){
		return userDao.selectByUsername(username);
	}
	
	//依据编号删除商品
	public void deleteUser(int id){
		userDao.deleteById(id);
	}
	
	//依据编号查询用戶
	public Users queryUserById(int id){
		return userDao.selectById(id);
	}
	
	//修改用戶信息
	public void updateUser(Users user){
		userDao.updateById(user);
	}


	
}
