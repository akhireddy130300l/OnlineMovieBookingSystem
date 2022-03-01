package com.moviebooking.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.moviebooking.bean.Admin;
import com.moviebooking.rowmapper.AdminrowMapper;

public class AdminServiceImpl implements AdminService {

	private JdbcTemplate jt = null;
	
	
	public AdminServiceImpl() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/moviedb8?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("priyatham");
        jt = new JdbcTemplate(dataSource);
	}


	public Admin AdminCheck(String email, String pwd) {
		// TODO Auto-generated method stub
		String adminchk = "select * from Admin where email=? and password=?";
		Admin adm  = null;
		System.out.println(email+" and    "+pwd);
		try
		{
		
			adm = jt.queryForObject(adminchk, new Object[]{email,pwd}, new AdminrowMapper());
		return adm;
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			System.out.println("Admin check fail");
			return null;
		}
	}

}
