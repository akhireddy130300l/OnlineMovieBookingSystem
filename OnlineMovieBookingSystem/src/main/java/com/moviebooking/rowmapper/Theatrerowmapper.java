package com.moviebooking.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.moviebooking.bean.Customer;
import com.moviebooking.bean.Theatre;

public class Theatrerowmapper implements RowMapper<Theatre> {

	public Theatre mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Theatre the = new Theatre();
		the.setId(rs.getInt(1));
		the.setName(rs.getString(2));
		the.setLocation(rs.getString(3));
		the.setNoofseats(rs.getInt(4));
		the.setNoofrows(rs.getInt(5));
		
		return the;
	}

	
}


//public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
//	// TODO Auto-generated method stub
//	Customer cus = new Customer();
//	
//	cus.setId(rs.getInt(1));
//	cus.setName(rs.getString(2));
//	cus.setEmail(rs.getString(3));
//	return cus;
//}