package com.mykheikin.springproject.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mykheikin.springproject.dao.RoleDao;
import com.mykheikin.springproject.dao.UserDao;
import com.mykheikin.springproject.generator.RoleGenerator;
import com.mykheikin.springproject.model.Role;
import com.mykheikin.springproject.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleGenerator roleGenerator;

	@Override
	public User findById(int id) {
		return userDao.findById(id);
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public void save(User user) {
		/*Set<Role> roles = new HashSet<>();
		roles.add(roleDao.findById(1));
		entity.setRoles(roles);*/
		User entity = roleGenerator.generator(user);		
		entity.setPassword(passwordEncoder.encode(user.getPassword()));
		userDao.save(entity);		
	}

	@Override
	public void update(User user) {
		User entity = userDao.findById(user.getId());
		if(entity!=null){
			entity.setUsername(user.getUsername());
			if(!user.getPassword().equals(entity.getPassword())){
				entity.setPassword(passwordEncoder.encode(user.getPassword()));
			}
			entity.setFirstName(user.getFirstName());
			entity.setLastName(user.getLastName());
			entity.setPatronymic(user.getPatronymic());
			entity.setRoles(user.getRoles());
		}
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);		
	}

	@Override
	public List<User> findAllUsers() {
		return userDao.findAllUsers();
	}

	@Override
	public boolean isUsernameUnique(Integer id, String username) {
		User user = findByUsername(username);
		return ( user == null || ((id != null) && (user.getId() == id)));
	}
}
