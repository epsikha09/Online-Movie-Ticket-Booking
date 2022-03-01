package com.mts.service;

import java.util.List;

import com.mts.exception.TicketNotFoundException;
import com.mts.model.Ticket;

public interface TicketService {
	public Ticket addTicket(Ticket ticket,Integer bookingId) throws TicketNotFoundException;

	public Ticket findTicket(int ticketId);

	List<Ticket> viewTicketList() throws TicketNotFoundException;

}
