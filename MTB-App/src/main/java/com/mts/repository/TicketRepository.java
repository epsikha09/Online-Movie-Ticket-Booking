package com.mts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mts.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
