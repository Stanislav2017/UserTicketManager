package com.mykheikin.manager.service;

import java.util.List;

import com.mykheikin.manager.model.User;

public interface UserService {

	User findById(int id);

	void save(User user);
	
	void update(User user);

	void deleteById(int id);

	List<User> findAllUser();
}
