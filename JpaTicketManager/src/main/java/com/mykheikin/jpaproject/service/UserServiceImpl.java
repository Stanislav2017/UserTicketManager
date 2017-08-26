package com.mykheikin.jpaproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mykheikin.jpaproject.generator.RoleGenerator;
import com.mykheikin.jpaproject.model.User;
import com.mykheikin.jpaproject.repositories.UserRepository;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleGenerator roleGenerator;

	@Override
	public User findById(int id) {
		return userRepository.findOne((long) id);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public void save(User user) {
		User entity = roleGenerator.generator(user);		
		entity.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(entity);		
	}

	@Override
	public void update(User user) {
		userRepository.save(user);	
	}

	@Override
	public void delete(int id) {
		userRepository.delete((long)id);
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public boolean isUsernameUnique(Integer id, String username) {
		User user = findByUsername(username);
		return ( user == null || ((id != null) && (user.getId() == id)));
	}	
}
