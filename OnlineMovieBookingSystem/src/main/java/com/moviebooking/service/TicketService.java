package com.moviebooking.service;

import java.util.List;

import com.moviebooking.bean.Ticket;

public interface TicketService {
	public int addTicket(String dateofbooking,String seatnumbers,int movie,int theatre,int show,int price);
	public Ticket lastRow();
	public List<Ticket> getTicketsByCustomerId(int customerId);

}
