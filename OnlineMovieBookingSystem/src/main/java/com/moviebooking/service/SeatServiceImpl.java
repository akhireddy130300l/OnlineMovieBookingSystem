package com.moviebooking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.moviebooking.bean.Movie;
import com.moviebooking.bean.Seat;
import com.moviebooking.bean.Theatre;
import com.moviebooking.rowmapper.MovierowMapper;
import com.moviebooking.rowmapper.SeatrowMapper;
import com.moviebooking.rowmapper.Theatrerowmapper;

public class SeatServiceImpl implements Seatservice {
	private JdbcTemplate jt = null;
	
	public SeatServiceImpl()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/moviedb8?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("priyatham");
        jt = new JdbcTemplate(dataSource);
	
	}
	public int addseattoDB(Theatre theatre) {
		// TODO Auto-generated method stub
		int noofseats = theatre.getNoofseats();
		int theatreid = theatre.getId();
		int noofrows = theatre.getNoofrows();
		String s = "insert into Seat(seatrow,seatno,theatreid) values(?,?,?)";
		String rowList = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		 int noofseatsperrow = (int) noofseats/noofrows;
		
		for(int i =1;i<=noofrows;i++)
		{
			String charAt = Character.toString(rowList.charAt(i-1));
			for(int j=1;j<=noofseatsperrow;j++)
			{
				
			try
			{
				jt.update(s, new Object[] {charAt,j,theatreid});
			}
			catch(Exception e)
			{
				System.out.println(e);
				System.out.println("unable to add seats to the theatre");
				return 0;
			}
			}
		}
		return 1;
	}
	public int removeSeatsofTheatre(int TheatreId) {
		// TODO Auto-generated method stub
		String s ="delete from Seat where theatreid=?";
		try
		{
			jt.update(s, new Object[] {TheatreId});
		}
		catch(Exception e)
		{
			System.out.println(e);
			return 0;
		}
		return 1;
	}
	public Movie getMovieIdbyShowId(int showId) {
		// TODO Auto-generated method stub
		
		String s = "select m.* from Movie m inner join Shows s on m.id = s.movieId where s.id=?";
		
		try
		{
		  Movie movie = jt.queryForObject(s,new Object[] {showId},new MovierowMapper());
			
			return movie;
		}
		catch(Exception e)
		{
			System.out.println(e + "  ");
			System.out.println("  Seat serviceImpl line 78");
			return null;
			
		}
		
	
	}
	public Theatre getTheatrebyShowId(int showId) {
		// TODO Auto-generated method stub
		
		String s = "select t.* from Theatre t inner join Shows s on t.id = s.theatreid where s.id=?";
		try
		{
			Theatre theatre = jt.queryForObject(s,new Object[] {showId},new Theatrerowmapper());
			return theatre;
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println("seatServiceImpl line 101");
			return null;
		}
	}
	public List<Seat> seatsByTheatre(Theatre theatre) {
		// TODO Auto-generated method stub
		String s = "select * from Seat where theatreid=?";
		
		try
		{
			List<Seat> query = jt.query(s,new Object[] {theatre.getId()},new SeatrowMapper());
			return query;
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println(" seatServiceImpl lin1 119");
			return null;
		}
		
	}
	public Seat getSeatBySeatId(int sId) {
		// TODO Auto-generated method stub
		String s = "select * from Seat where id=?";
		
		try
		{
			Seat seat = jt.queryForObject(s,new Object[] {sId},new SeatrowMapper());
			return seat;
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println("line no 137 in seatserviceImpl");
			return null;
		}

	}

}
