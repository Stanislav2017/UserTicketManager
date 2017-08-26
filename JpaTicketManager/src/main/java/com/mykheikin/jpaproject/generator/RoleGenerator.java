package com.mykheikin.jpaproject.generator;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mykheikin.jpaproject.model.Role;
import com.mykheikin.jpaproject.model.User;
import com.mykheikin.jpaproject.service.RoleService;

@Component("roleGenerator")
public class RoleGenerator {

	@Autowired
	private RoleService roleService;

	public User generator(User user) {
		User entity = user;
		String firstName = entity.getFirstName();
		Set<Role> roles = new HashSet<>();
		if (firstName.startsWith("ADMIN")) {
			roles.add(roleService.findByName("ADMIN"));
			entity.setRoles(roles);
			entity.setFirstName(entity.getFirstName().replace("ADMIN", ""));
		} else if (firstName.startsWith("DBA")) {
			roles.add(roleService.findByName("DBA"));
			entity.setRoles(roles);
			entity.setFirstName(entity.getFirstName().replace("DBA", ""));
		} else {
			roles.add(roleService.findByName("USER"));
			entity.setRoles(roles);
		}
		return entity;
	}
}
