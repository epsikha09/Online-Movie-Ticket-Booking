package com.mts.service;

import java.time.LocalDate;
import java.util.List;

import com.mts.exception.BookingNotFoundException;
import com.mts.exception.ScreenNotFoundException;
import com.mts.model.Booking;
import com.mts.model.Screen;

public interface IBookingService {
	public Booking addBooking(Booking booking, Integer customerId,Integer showId) throws BookingNotFoundException;

	public List<Booking> viewBookingList() throws BookingNotFoundException;

	public Booking updateBooking(Booking booking) throws BookingNotFoundException;

	public Booking cancelBooking(int bookingid) throws BookingNotFoundException;

	public List<Booking> showAllBookings(int movieid) throws BookingNotFoundException;
	public Booking viewBooking(int bookingid) throws BookingNotFoundException;
	public List<Booking> showAllBookings(LocalDate bookingdate) throws BookingNotFoundException;

	public double calculateTotalCost(int bookingid);

}
