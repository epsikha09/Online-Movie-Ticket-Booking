package com.mts.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mts.exception.BookingNotFoundException;
import com.mts.model.Booking;
import com.mts.model.Customer;
import com.mts.model.Seat;
import com.mts.model.Show;
import com.mts.model.Ticket;
import com.mts.repoImpl.QueryClass;
import com.mts.repository.BookingRepository;
import com.mts.repository.CustomerRepository;
import com.mts.repository.MoviesRepository;
import com.mts.repository.ShowRepository;
import com.mts.repository.TicketRepository;

@Service
public class BookingServiceImpl implements IBookingService {

	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	MoviesRepository moviesRepository;
	@Autowired
	ShowRepository showRepository;
	@Autowired
	CustomerRepository custoRepository;
	@Autowired
	TicketRepository ticketRepository;
	@Autowired
	QueryClass query;

	@Override
	public Booking addBooking(Booking booking, Integer customerId, Integer showId) throws BookingNotFoundException {
		Customer customer = new Customer();
		Show show=new Show();
		
		if(showId!=null) {
				//customer = custoRepository.getOne(customerId);
				show=showRepository.findById(showId).get();
				show.setBooking(booking);
				//booking.setCustomer(customer);
				booking.setShow(show);
		}
			bookingRepository.saveAndFlush(booking);
			showRepository.saveAndFlush(show);
		return bookingRepository.findById(booking.getTransactionId()).get();
	}

	@Override
	public Booking updateBooking(Booking booking) throws BookingNotFoundException {
		bookingRepository.saveAndFlush(booking);
		return bookingRepository.getOne(booking.getTransactionId());
	}

	@Override
	public Booking cancelBooking(int bookingid) throws BookingNotFoundException {
		Booking b = bookingRepository.getOne(bookingid);
		bookingRepository.delete(b);
		return b;
	}

	@Override
	public List<Booking> showAllBookings(int movieid) throws BookingNotFoundException {
		List<Booking> bk = query.getAllByMovieId(movieid);
		
		return bk;
	}

	@Override
	public List<Booking> showAllBookings(LocalDate bookingdate) throws BookingNotFoundException {
		List<Booking> bkList = new ArrayList<>();
		for (Booking booking : bookingRepository.findAll()) {
			if (booking.getBookingDate() != null && booking.getBookingDate().isEqual(bookingdate)) {
				bkList.add(booking);
			}
		}
		if (bkList.size() == 0)
			throw new BookingNotFoundException("No bookings found");
		else {
			return bkList;
		}
	}

	@Override
	public double calculateTotalCost(int bookingid) {
		List<Ticket> tickets = ticketRepository.findAll();
		Set<Seat> Seats = new HashSet<>();
		for (Ticket ticket : tickets) {
			if (bookingid == ticket.getBooking().getTransactionId()) {
				Seats.addAll(ticket.getSeats());
			}
		}
		double amount = 0;
		for (Seat seat : Seats) {
			amount = amount + seat.getPrice();
		}
		Booking booking = bookingRepository.getOne(bookingid);
		booking.setTotalCost(amount);
		bookingRepository.saveAndFlush(booking);
		return amount;
	}

	@Override
	public List<Booking> viewBookingList() throws BookingNotFoundException {
		List<Booking> bk = bookingRepository.findAll();
		
		return bk;
	}

	@Override
	public Booking viewBooking(int bookingid) throws BookingNotFoundException {
		return bookingRepository.findById(bookingid).get();
	}

}
