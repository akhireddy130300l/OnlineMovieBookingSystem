package com.moviebooking.service;

import java.util.List;

import com.moviebooking.bean.Seat;

public interface BookingService {

	public int addBooking(int cid,String date,int ticketId);
	public List<Seat> bookedseats(String date,int showId);
}
