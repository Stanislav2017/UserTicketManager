package com.mykheikin.manager.dao;

import java.util.List;

import com.mykheikin.manager.model.User;

public interface UserDao {

	User findById(int id);

	void save(User user);

	void deleteById(int id);

	List<User> findAllUser();
}
