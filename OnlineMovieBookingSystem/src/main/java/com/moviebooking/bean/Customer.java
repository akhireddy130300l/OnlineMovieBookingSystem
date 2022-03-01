package com.moviebooking.bean;

public class Customer {
	
	private int id;
	private String name;
	private String email;
	private String phoneno;
	private String password;
	public int getId() {
		return id;
	}

	

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public Customer(String name, String email, String phoneno, String password) {
		this.name = name;
		this.email = email;
		this.phoneno = phoneno;
		this.password = password;
	}



	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", phoneno=" + phoneno + ", password="
				+ password + "]";
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer(int id,String name, String email, String phoneno, String password) {
		this.id =id;
		this.name = name;
		this.email = email;
		this.phoneno = phoneno;
		this.password = password;
	}
	public Customer() {
	
	}

}
