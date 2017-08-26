package com.mykheikin.jpaproject.service;

import java.util.List;

import com.mykheikin.jpaproject.model.User;

public interface UserService {

	User findById(Long id);
	
	User findByUsername(String username);
	
	void save(User user);
	
	void update(User user);
	
	void delete(Long id);
	
	List<User> findAllUsers();
	
	boolean isUsernameUnique(Long id, String username);
}
