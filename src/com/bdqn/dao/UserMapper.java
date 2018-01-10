package com.bdqn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bdqn.entity.User;
import com.bdqn.entity.UserEx;

public interface UserMapper {
	
	public int count();
	
	public List<User> getUserListByName(String name);
	
	public List<User> getUserList(User user);
	
	public List<UserEx> getUserListAndRole(User user);
	
	public int delUser(@Param("id")int id);
}
