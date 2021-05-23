package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.entity.Users;

public interface UsersDao {
    int deleteById(Integer id);//按照id删除

    int insert(Users record);//新加用户

    int insertSelective(Users record);

    Users selectById(Integer id);//按照id查找用户

    int updateByIdSelective(Users record);

    int updateById(Users record);  //更新用户  
    
    
	/**
	 * 依据名称模糊查找用户
	 * @param username
	 * @return
	 */
    @Select("select * from users where username like '%'+#{username}+'%' order by id asc")
	public List<Users> getListByName(@Param("username")String username);
	
	/**
	 * 依据名称查找用户是否存在
	 * @param username
	 * @return
	 */
    @Select("select * from users where username=#{username}")
	public Users isExist(@Param("username")String username);
    
	/**
	 * 依据名称查找用户
	 * @param username
	 * @return
	 */
    @Select("select * from users where username=#{username}")
	public Users selectByUsername(@Param("username")String username);
    
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return 
	 */
    @Select("select * from users where username=#{username} and password=#{password}")
	public Users getByUsernameAndPassword(@Param("username")String username, @Param("password")String password);
	
	/**
	 * 查询所有用户信息
	 * @return 
	 */
    @Select("select * from users order by id asc")
	public List<Users> getList();

	/**
	 * 查询用户总数
	 * @return
	 */
    @Select("select count(*) from users")
	public int getTotal();
	
    
}