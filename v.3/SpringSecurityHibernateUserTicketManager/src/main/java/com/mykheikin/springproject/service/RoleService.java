package com.mykheikin.springproject.service;

import java.util.List;

import com.mykheikin.springproject.model.Role;

public interface RoleService {

	List<Role> findAll();

	Role findByName(String name);

	Role findById(int id);
}
