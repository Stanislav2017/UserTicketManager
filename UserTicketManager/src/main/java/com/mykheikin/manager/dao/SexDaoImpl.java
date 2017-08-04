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

@Repository("sexDao")
public class SexDaoImpl extends AbstractDao<Integer, Sex> implements SexDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	private static final Logger logger = LoggerFactory.getLogger(SexDaoImpl.class);
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Sex> findAllSex() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		List<Sex> sexList = (List<Sex>) criteria.list();
		
		for(Sex sex: sexList){
			logger.info("Sex successfully load. Sex details: " + sex);
		}

		return sexList;
	}

	@Override
	public Sex findById(int id) {
		return getByKey(id);
	}
}
