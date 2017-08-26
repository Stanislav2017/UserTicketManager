package com.mykheikin.jpaproject.service;

import java.util.List;

import com.mykheikin.jpaproject.model.User;

public interface UserService {

	User findById(int id);
	
	User findByUsername(String username);
	
	void save(User user);
	
	void update(User user);
	
	void delete(int id);
	
	List<User> findAllUsers();
	
	boolean isUsernameUnique(Integer id, String username);
}
