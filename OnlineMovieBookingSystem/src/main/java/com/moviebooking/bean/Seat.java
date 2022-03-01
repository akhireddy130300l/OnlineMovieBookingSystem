package com.moviebooking.bean;

public class Seat {
	private int id;
	private int seatno;
	private String seatrow;
	private int theatreid;
	
	
	
	
	@Override
	public String toString() {
		return "Seat [id=" + id + ", seatno=" + seatno + ", seatrow=" + seatrow + ", theatreid=" + theatreid + "]";
	}



	/**
	 * 
	 */
	public Seat() {
	}



	/**
	 * @param id
	 * @param seatno
	 * @param seatrow
	 * @param theatreid
	 */
	public Seat(int id, int seatno, String seatrow, int theatreid) {
		this.id = id;
		this.seatno = seatno;
		this.seatrow = seatrow;
		this.theatreid = theatreid;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getSeatno() {
		return seatno;
	}

	public void setSeatno(int seatno) {
		this.seatno = seatno;
	}

	public int getTheatreid() {
		return theatreid;
	}

	public void setTheatreid(int theatreid) {
		this.theatreid = theatreid;
	}

	public String getSeatrow() {
		return seatrow;
	}

	public void setSeatrow(String seatrow) {
		this.seatrow = seatrow;
	}
}
