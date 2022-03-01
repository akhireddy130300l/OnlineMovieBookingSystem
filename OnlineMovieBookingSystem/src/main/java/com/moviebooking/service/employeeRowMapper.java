package com.moviebooking.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.moviebooking.bean.Customer;

public class employeeRowMapper implements RowMapper<Customer> {

	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Customer cus = new Customer();
		
		cus.setId(rs.getInt(1));
		cus.setName(rs.getString(2));
		cus.setEmail(rs.getString(3));
		cus.setPhoneno(rs.getString(4));
		cus.setPassword(rs.getString(5));
		
		System.out.println(cus+"gfjfgifgifgighf");
		return cus;
	}


}
