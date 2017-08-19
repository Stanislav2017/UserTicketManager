package com.mykheikin.springproject.dao;

import java.util.List;

import com.mykheikin.springproject.model.User;

public interface UserDao {

	User findById(int id);
	
	User findByUsername(String username);
	
	void save(User user);
	
	void delete(int id);
	
	List<User> findAllUsers();
}
