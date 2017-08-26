package com.mykheikin.jpaproject.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.mykheikin.jpaproject.model.Role;
import com.mykheikin.jpaproject.service.RoleService;

@Component
public class RoleToUserProfileConverter implements Converter<Object, Role> {

	static final Logger logger = LoggerFactory.getLogger(RoleToUserProfileConverter.class);

	@Autowired
	private RoleService roleService;

	public Role convert(Object element) {
		Integer id = Integer.parseInt((String) element);
		Role role = roleService.findById(id);
		logger.info("Profile : {}", role);
		return role;
	}
}
