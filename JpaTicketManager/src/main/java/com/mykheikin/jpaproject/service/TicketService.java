package com.mykheikin.jpaproject.service;

import com.mykheikin.jpaproject.model.Ticket;

public interface TicketService {

	Ticket findById(Long id);
	
	void save(Ticket ticket);
	
	void update(Ticket ticket);
	
	void delete(Long id);
	
}
