package com.mykheikin.springproject.dao;

import java.util.List;

import com.mykheikin.springproject.model.Role;

public interface RoleDao {
	
	List<Role> findAll();

	Role findByName(String name);

	Role findById(int id);

}
