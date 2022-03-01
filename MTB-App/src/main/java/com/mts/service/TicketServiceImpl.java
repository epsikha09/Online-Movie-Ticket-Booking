package com.mts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mts.exception.TicketNotFoundException;
import com.mts.model.Booking;
import com.mts.model.Seat;
import com.mts.model.Ticket;
import com.mts.repository.BookingRepository;
import com.mts.repository.SeatRepository;
import com.mts.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	private TicketRepository ticketRepository;

	public TicketServiceImpl(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}
	
	@Autowired
	private SeatRepository seatRepository;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Override
	public Ticket addTicket(Ticket ticket,Integer transactionId) throws TicketNotFoundException {
		Booking booking=new Booking();
		if(transactionId!=null) {
			booking=bookingRepository.findById(transactionId).get();
			booking.setTransactionStatus("Completed");
			ticket.setBooking(booking);
		}
		ticketRepository.saveAndFlush(ticket);
		/*
		 * for(Seat s:ticket.getSeats()) { s.setTickett(ticket);
		 * seatRepository.saveAndFlush(s); }
		 */
		return ticket;
	}

	@Override
	public List<Ticket> viewTicketList() throws TicketNotFoundException {
		List<Ticket> ti = ticketRepository.findAll();
		if (ti.size() == 0)
			throw new TicketNotFoundException("No tickets are avaliable");
		return ti;
	}

	@Override
	public Ticket findTicket(int ticketId) {
		// TODO Auto-generated method stub
		return ticketRepository.findById(ticketId).get();
	}

}
