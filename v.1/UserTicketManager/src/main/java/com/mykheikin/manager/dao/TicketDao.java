package com.mykheikin.manager.dao;

import java.util.List;

import com.mykheikin.manager.model.Ticket;

public interface TicketDao {
	
	Ticket findById(int id);

	void save(Ticket ticket);

	void deleteById(int id);

	List<Ticket> findAllTicket();

}
