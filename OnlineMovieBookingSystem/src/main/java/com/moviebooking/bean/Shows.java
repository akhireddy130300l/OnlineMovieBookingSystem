package com.moviebooking.bean;

public class Shows {
	private  int id;
	private String starttime ;
	private int movieid ;
	private int theatreid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public int getMovieid() {
		return movieid;
	}

	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}

	public int getTheatreid() {
		return theatreid;
	}

	public void setTheatreid(int theatreid) {
		this.theatreid = theatreid;
	}

	public Shows() {
	}

	public Shows(int id, String starttime, int movieid, int theatreid) {
		this.id = id;
		this.starttime = starttime;
		this.movieid = movieid;
		this.theatreid = theatreid;
	}

	@Override
	public String toString() {
		return "Shows [id=" + id + ", starttime=" + starttime + ", movieid=" + movieid + ", theatreid=" + theatreid
				+ "]";
	}
	
}
