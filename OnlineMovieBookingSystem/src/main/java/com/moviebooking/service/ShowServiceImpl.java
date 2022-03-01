package com.moviebooking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.moviebooking.bean.Shows;
import com.moviebooking.bean.Theatre;
import com.moviebooking.rowmapper.ShowrowMapper;
import com.moviebooking.rowmapper.Theatrerowmapper;

public class ShowServiceImpl implements ShowService {
	private JdbcTemplate jt = null;
	public ShowServiceImpl()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/moviedb8?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("priyatham");
        jt = new JdbcTemplate(dataSource);
	
	}

	public int addShow(String movieStartTime, int MovieId, int TheatreId) {
		// TODO Auto-generated method stub
		String s = "insert into Shows(starttime,movieid,theatreid) values(?,?,?)";
		int r =0;
		try {
			r = jt.update(s,new Object[] {movieStartTime,MovieId,TheatreId});
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			return 0;
		}
		if(r!=0) {
			return 1;
		}
		else {
			return 0;
		}
	}

	public List<Shows> allShows() {
		// TODO Auto-generated method stub
		String s = "select * from Shows";
		try {
			List<Shows> allshows = jt.query(s, new ShowrowMapper());
			
			return allshows;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public int removeShow(int id) {
		// TODO Auto-generated method stub
		String s = "delete from Shows where id=?";
		int r = 0;
		try {
			r = jt.update(s, new Object[] {id});
		}
		catch(Exception e)
		{
			System.out.println(e);
			return 0;
		}
		if(r!=0) return 1;
		else return 0;
	}

	public int updateShow(int showId, int MovieId) {
		// TODO Auto-generated method stub
		String s = "update Shows set movieid=? where id=?";
		int r;
		try {
			r = jt.update(s,MovieId,showId);
		}
		catch(Exception e)
		{
			System.out.println(e);
			return 0;
		}
		if(r!=0) return 1;
		else return 0;
		
	}

	public List<Shows> allShowsbyTheatre(List<Theatre> theatresByMovieSelected ,int movieId) {
		// TODO Auto-generated method stub
		
		List<Shows> allShows = new ArrayList<Shows>();
		String s ="Select * from Shows where theatreid=? and movieid=?";
		try {
			for(Theatre t:theatresByMovieSelected)
			{
				List<Shows> query = jt.query(s, new Object[] {t.getId(),movieId},new ShowrowMapper());
				allShows.addAll(query);
			}
			return allShows;
			
		}
		catch(Exception e)
		{
			return null;
		}
	
	}

	public Shows showTimeById(int sId) {
		// TODO Auto-generated method stub
		String s ="select * from Shows where id=?";
		try
		{
		 Shows queryForObject = jt.queryForObject(s,new Object[] {sId},new ShowrowMapper());
		 return queryForObject;
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println("showserivce impl line no 126 error");
			return null;
		}
	}


}
