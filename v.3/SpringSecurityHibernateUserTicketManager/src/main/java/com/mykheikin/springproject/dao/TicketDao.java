package com.mykheikin.springproject.dao;

import java.util.List;

import com.mykheikin.springproject.model.Ticket;

public interface TicketDao {

	Ticket findById(int id);

	void save(Ticket ticket);

	void deleteById(int id);

	List<Ticket> findAllTicket();

}
