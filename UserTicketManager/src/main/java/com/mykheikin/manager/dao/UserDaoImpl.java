package com.mykheikin.manager.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mykheikin.manager.model.Sex;
import com.mykheikin.manager.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	@Override
	public User findById(int id) {
		User user = getByKey(id);
		logger.info("User successfully load. User details: " + user);
		return user;
	}

	@Override
	public void save(User user) {
		persist(user);
		logger.info("User successfully saved. User details: " + user);
	}

	@Override
	public void deleteById(int id) {
		User user = getByKey(id);
		delete(user);
		logger.info("User successfully deleted. User details: " + user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUser() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		List<User> userList = (List<User>) criteria.list();

		for (User user : userList) {
			logger.info("User successfully load. User details: " + user);
		}

		return userList;

	}

}
