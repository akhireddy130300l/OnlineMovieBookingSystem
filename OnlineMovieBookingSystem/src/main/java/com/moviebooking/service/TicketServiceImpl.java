package com.moviebooking.service;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.moviebooking.bean.Ticket;
import com.moviebooking.rowmapper.TicketRowMapper;

public class TicketServiceImpl implements TicketService {
	
	private JdbcTemplate jt = null;
	
	public TicketServiceImpl()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/moviedb8?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("priyatham");
        jt = new JdbcTemplate(dataSource);
	}
	

	public int addTicket(String dateofbooking,String seatnumbers, int movie, int theatre, int show,int price) {
		// TODO Auto-generated method stub
		String s = "insert into Ticket(dateofbooking,seatno,movieid,showid,theatreid,price) values(?,?,?,?,?,?)";
		int r;
		try
		{
			 r = jt.update(s,new Object[] {dateofbooking,seatnumbers,movie,show,theatre,price});
		}
		catch(Exception e)
		{
			System.out.println(e);
			return 0;
		}
		if(r!=0)
			return 1;
		else
			return 0;
	}


	public Ticket lastRow() {
		// TODO Auto-generated method stub
		String s="select * from Ticket order by id desc limit 1";
		
		try
		{
			Ticket ticket = jt.queryForObject(s,new TicketRowMapper());
			return ticket;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println();
		}
		return null;
	}


	public List<Ticket> getTicketsByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		String s = "select ti.* from Theatre t\n"
				+ "inner join Ticket ti on ti.theatreid=t.id\n"
				+ "inner join Booking b on b.ticketid=ti.id where b.cid=?";
		
		try {
			
			List<Ticket> query = jt.query(s, new Object[] {customerId},new TicketRowMapper());
			return query;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			System.out.println("Ticketservice impl line no 76");
			return null;
		}
	}

}
