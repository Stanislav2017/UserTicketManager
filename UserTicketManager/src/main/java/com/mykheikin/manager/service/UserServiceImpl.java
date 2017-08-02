package com.mykheikin.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mykheikin.manager.dao.UserDao;
import com.mykheikin.manager.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User findById(int id) {
		return userDao.findById(id);
	}

	@Override
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	public void update(User user) {

		User entity = userDao.findById(user.getId());

		if (entity != null) {
			entity.setFirstName(user.getFirstName());
			entity.setLastName(user.getLastName());
			entity.setPatronymic(user.getPatronymic());
			entity.setPassword(user.getPassword());
			entity.setSex(user.getSex());
			entity.setUsername(user.getUsername());
			entity.setTickets(user.getTickets());
		}
	}

	@Override
	public void deleteById(int id) {
		userDao.deleteById(id);
	}

	@Override
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}
}
