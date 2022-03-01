package com.moviebooking.bean;

public class Theatre {
	@Override
	public String toString() {
		return "Theatre [id=" + id + ", name=" + name + ", location=" + location + ", noofseats=" + noofseats
				+ ", noofrows=" + noofrows + "]";
	}

	private int id;

	private String name;
	private String location;
	private int noofseats;
	private int noofrows;

	
	public Theatre(int id, String name, String location, int noofseats, int noofrows) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.noofseats = noofseats;
		this.noofrows = noofrows;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	

	public Theatre()
	{
		
	}

	public int getNoofseats() {
		return noofseats;
	}

	public void setNoofseats(int noofseats) {
		this.noofseats = noofseats;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNoofrows() {
		return noofrows;
	}

	public void setNoofrows(int noofrows) {
		this.noofrows = noofrows;
	}

}
