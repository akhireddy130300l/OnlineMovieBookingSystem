package com.moviebooking.bean;

public class Booking {

	private int id;
	private int cid;
	private String date;
	private int ticketid;

	/**
	 * 
	 */
	public Booking() {
	}

	/**
	 * @param id
	 * @param cid
	 * @param date
	 * @param ticketid
	 */
	public Booking(int id, int cid, String date, int ticketid) {
		this.id = id;
		this.cid = cid;
		this.date = date;
		this.ticketid = ticketid;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", cid=" + cid + ", date=" + date + ", ticketid=" + ticketid + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getTicketid() {
		return ticketid;
	}

	public void setTicketid(int ticketid) {
		this.ticketid = ticketid;
	}

}
