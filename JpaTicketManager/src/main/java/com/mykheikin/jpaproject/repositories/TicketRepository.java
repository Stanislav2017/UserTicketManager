package com.mykheikin.jpaproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mykheikin.jpaproject.model.Ticket;

@Repository("ticketRepository")
public interface TicketRepository extends JpaRepository<Ticket, Long>{
}
