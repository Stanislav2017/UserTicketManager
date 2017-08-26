package com.mykheikin.jpaproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mykheikin.jpaproject.model.Role;
import com.mykheikin.jpaproject.repositories.RoleRepository;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role findById(Long id) {
		return roleRepository.findOne(id);
	}

	@Override
	public Role findByName(String name) {
		return roleRepository.findByName(name);
	}	
}
