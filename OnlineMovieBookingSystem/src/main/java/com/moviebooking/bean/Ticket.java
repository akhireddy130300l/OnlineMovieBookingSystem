package com.moviebooking.bean;

public class Ticket {
	private int id;
	private String dateofbooking;
	private String seatno;
	private int movieid;
	private int showid;
	private int theatreid;
	private int price;
	


	/**
	 * @param id
	 * @param dateofbooking
	 * @param seatno
	 * @param movieid
	 * @param showid
	 * @param theatreid
	 * @param price
	 */
	public Ticket(int id, String dateofbooking, String seatno, int movieid, int showid, int theatreid, int price) {
		this.id = id;
		this.dateofbooking = dateofbooking;
		this.seatno = seatno;
		this.movieid = movieid;
		this.showid = showid;
		this.theatreid = theatreid;
		this.price = price;
	}

	/**
	 * 
	 */
	public Ticket() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSeatno() {
		return seatno;
	}

	public void setSeatno(String seatno) {
		this.seatno = seatno;
	}

	public int getMovieid() {
		return movieid;
	}

	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}

	public int getShowid() {
		return showid;
	}

	public void setShowid(int showid) {
		this.showid = showid;
	}

	public int getTheatreid() {
		return theatreid;
	}

	public void setTheatreid(int theatreid) {
		this.theatreid = theatreid;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", dateofbooking=" + dateofbooking + ", seatno=" + seatno + ", movieid=" + movieid
				+ ", showid=" + showid + ", theatreid=" + theatreid + ", price=" + price + "]";
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDateofbooking() {
		return dateofbooking;
	}

	public void setDateofbooking(String dateofbooking) {
		this.dateofbooking = dateofbooking;
	}

}
