package com.mykheikin.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mykheikin.manager.dao.TicketDao;
import com.mykheikin.manager.model.Ticket;

@Service("ticketService")
@Transactional
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketDao ticketDao;

	@Override
	public Ticket findById(int id) {
		return ticketDao.findById(id);
	}

	@Override
	public void save(Ticket ticket) {
		ticketDao.save(ticket);		
	}

	@Override
	public void update(Ticket ticket) {
		Ticket entity = ticketDao.findById(ticket.getId());
		if (entity != null) {
			entity.setDate(ticket.getDate());
			entity.setPrice(ticket.getPrice());
		}		
	}

	@Override
	public void deleteById(int id) {
		ticketDao.deleteById(id);		
	}

	@Override
	public List<Ticket> findAllTicket() {
		return ticketDao.findAllTicket();
	}
}
