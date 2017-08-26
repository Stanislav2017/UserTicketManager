package com.mykheikin.jpaproject.service;

import java.util.List;

import com.mykheikin.jpaproject.model.Role;

public interface RoleService {

	List<Role> findAll();

	Role findByName(String name);

	Role findById(int id);
}
