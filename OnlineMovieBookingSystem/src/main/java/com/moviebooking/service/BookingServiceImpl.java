package com.moviebooking.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.moviebooking.bean.Seat;
import com.moviebooking.bean.Ticket;
import com.moviebooking.rowmapper.TicketRowMapper;

public class BookingServiceImpl implements BookingService {
	
	private JdbcTemplate jt = null;
	Seatservice seatimpl = new SeatServiceImpl();
	public BookingServiceImpl()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/moviedb8?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("priyatham");
        jt = new JdbcTemplate(dataSource);
	}

	public int addBooking(int cid, String date, int ticketId) {
		// TODO Auto-generated method stub
		String s="insert into Booking(cid,date,ticketid) values(?,?,?)";
		int r;
		try
		{
			r = jt.update(s,new Object[] {cid,date,ticketId});
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return 0;
		}
		if (r!=0) {
			return 1;
		} else {
			return 0;
		}
	}

	public List<Seat> bookedseats(String date, int showId) {
		// TODO Auto-generated method stub
		String s = "select ti.* from Theatre t\n"
				+ "inner join Ticket ti on ti.theatreid=t.id\n"
				+ "inner join Booking b on b.ticketid=ti.id where b.date=? and showid=?;";
		
		List<Seat> bookedseats = new ArrayList<Seat>();
		
		try
		{
			List<Ticket> query = jt.query(s,new Object[] {date,showId},new TicketRowMapper());
			
			for(Ticket t:query)
			{
				String seatno = t.getSeatno();
				String[] split = seatno.split(",");
				
				for(String seat:split)
				{
					Seat seatBySeatId = seatimpl.getSeatBySeatId(Integer.parseInt(seat));
					bookedseats.add(seatBySeatId);
				}
				
			}
			
			return bookedseats;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
		
	}


}
