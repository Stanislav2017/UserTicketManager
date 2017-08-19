package com.mykheikin.springproject.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.mykheikin.springproject.model.Role;
import com.mykheikin.springproject.service.RoleService;

/**
 * A converter class used in views to map id's to actual userProfile objects.
 */
@Component
public class RoleToUserProfileConverter implements Converter<Object, Role> {

	static final Logger logger = LoggerFactory.getLogger(RoleToUserProfileConverter.class);

	@Autowired
	RoleService roleService;

	public Role convert(Object element) {
		Integer id = Integer.parseInt((String) element);
		Role role = roleService.findById(id);
		logger.info("Profile : {}", role);
		return role;
	}
}
