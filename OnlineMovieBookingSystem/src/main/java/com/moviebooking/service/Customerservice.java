package com.moviebooking.service;

import com.moviebooking.bean.Customer;

public interface Customerservice {
	public int register(Customer c);
	public Customer UserCheck(String email, String pwd);
	public int changePassword(int cusId,String password);
	public int editprofile(int customerId,String newName,String newPhoneNumber);
	public Customer getCustomer(int cusId);

}
