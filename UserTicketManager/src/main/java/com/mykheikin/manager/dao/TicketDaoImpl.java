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

import com.mykheikin.manager.model.Ticket;

@Repository("ticketDao")
public class TicketDaoImpl extends AbstractDao<Integer, Ticket> implements TicketDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	private static final Logger logger = LoggerFactory.getLogger(TicketDaoImpl.class);

	@Override
	public Ticket findById(int id) {
		Ticket ticket = getByKey(id);
		logger.info("Ticket successfully load. Ticket details: " + ticket);
		return ticket;
	}

	@Override
	public void save(Ticket ticket) {
		persist(ticket);
		logger.info("Ticket successfully saved. Ticket details: " + ticket);
	}

	@Override
	public void deleteById(int id) {
		Ticket ticket = getByKey(id);
		delete(ticket);
		logger.info("Ticket successfully deleted. Ticket details: " + ticket);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> findAllTicket() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		List<Ticket> ticketList = (List<Ticket>) criteria.list();

		return ticketList;

	}

}
