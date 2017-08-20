package com.mykheikin.springproject.service;

import java.util.List;

import com.mykheikin.springproject.model.Ticket;

public interface TicketService {

	Ticket findById(int id);

	void save(Ticket ticket);

	void update(Ticket ticket);

	void deleteById(int id);

	List<Ticket> findAllTicket();

}
