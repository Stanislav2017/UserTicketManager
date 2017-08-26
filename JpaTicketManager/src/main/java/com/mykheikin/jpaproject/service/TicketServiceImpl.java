package com.mykheikin.jpaproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mykheikin.jpaproject.model.Ticket;
import com.mykheikin.jpaproject.repositories.TicketRepository;

@Service("ticketService")
@Transactional
public class TicketServiceImpl implements TicketService{
	
	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public Ticket findById(Long id) {
		return ticketRepository.findOne(id);
	}

	@Override
	public void save(Ticket ticket) {
		ticketRepository.save(ticket);		
	}

	@Override
	public void update(Ticket ticket) {
		save(ticket);		
	}

	@Override
	public void delete(Long id) {
		ticketRepository.delete(id);	
	}
}
