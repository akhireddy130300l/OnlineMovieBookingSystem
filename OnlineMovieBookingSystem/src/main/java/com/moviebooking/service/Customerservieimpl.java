package com.moviebooking.service;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.moviebooking.bean.Customer;

public class Customerservieimpl implements Customerservice {
	private JdbcTemplate jt = null;
	
	public Customerservieimpl() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/moviedb8?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("priyatham");
        jt = new JdbcTemplate(dataSource);
	}
	
	
	
	
	
	
	//CUSTOMER REGISTRATION
	public int register(Customer c) {
		String inscmd = "insert into Customer(name,email,phoneno,password) values(?,?,?,?)";
		int r;
		System.out.println(c.toString());
		try
		{
		 r = jt.update(inscmd, new Object[] {c.getName(),c.getEmail(),c.getPhoneno(),c.getPassword()});
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println("Fail to sign in the customer");
			return 0;
		}
		if(r!=0) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	
	
	
	
	
	public Customer UserCheck(String email, String pwd) {
		// TODO Auto-generated method stub
		String userchk = "select * from Customer where email=? and password=?";
		Customer chk = null;
		System.out.println(email+" and    "+pwd);
		try
		{
		
		chk = jt.queryForObject(userchk, new Object[]{email,pwd}, new employeeRowMapper());
		return chk;
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			System.out.println("user check fail");
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	public int changePassword(int cusId,String password) {
		// TODO Auto-generated method stub
		String s = "update Customer set password=? where id=?";
		
		try {
			 jt.update(s,new Object[] {password,cusId});
			return 1;
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println("unable to update the password");
			return 0;
		}
	}






	public int editprofile(int customerId, String newName, String newPhoneNumber) {
		String s="update Customer set  name=? , phoneno=? where id=?";
		System.out.println(newName+"         "+newPhoneNumber+"         "+customerId);
		try {
			jt.update(s,new Object[] {newName,newPhoneNumber,customerId});
			return 1;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return 0;
		}
		
	}






	public Customer getCustomer(int cusId) {
		// TODO Auto-generated method stub
		String s = "select * from Customer where id=?";
		try {
			Customer cus = jt.queryForObject(s, new Object[] {cusId}, new employeeRowMapper());
			
			System.out.println(cus.toString());
			return cus;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}

	}

}
