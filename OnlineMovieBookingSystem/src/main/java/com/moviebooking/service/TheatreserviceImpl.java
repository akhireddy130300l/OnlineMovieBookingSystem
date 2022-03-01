package com.moviebooking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.moviebooking.bean.Theatre;
import com.moviebooking.rowmapper.Theatrerowmapper;

public class TheatreserviceImpl implements Theatreservice {

	private JdbcTemplate jt = null;
	public TheatreserviceImpl()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/moviedb8?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("priyatham");
        jt = new JdbcTemplate(dataSource);
	}
	
	public List<Theatre> allTheatreLoaction() {
		// TODO Auto-generated method stub
		
		String s = "select  *  from Theatre";
		try
		{
		List<Theatre> the = jt.query(s, new Theatrerowmapper());
		
		return the;
		}
		catch(Exception E)
		{
			System.out.println(E);
			System.out.println("sasas");
			return null;
		}
		
		
	}

	public int addTheatre(String theatreName, String theatreLocation, int noofSeats,int noofrows) {
		// TODO Auto-generated method stub
		String s ="insert into Theatre(name,location,noofseats,noofrows) values (?,?,?,?)";
		int r = 0;
		try 
		{
			 r = jt.update(s, new Object[] {theatreName,theatreLocation,noofSeats,noofrows});
		}
		catch(Exception e)
		{
			System.out.println("Failed to add theatre to db");
			return 0;
		}
		if(r!=0) {
			return 1;
		}
		else {
			return 0;
		}
	}

	public int removeTheatre(int TheatreId, String TheatreName) {
		// TODO Auto-generated method stub
		String s ="delete from Theatre where id=? and name=?";
		int r;
		try {
			r =jt.update(s,new Object[] {TheatreId,TheatreName});	
			
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

	public Theatre getTheatre(String theatreName) {
		// TODO Auto-generated method stub
		String s = "select * from Theatre where name=?";
		try
		{
			List<Theatre> tlist = jt.query(s, new Object[] {theatreName},new Theatrerowmapper());
			Theatre  t = tlist.get(0);
			System.out.println(t.toString()+"     "+"Printing in the theatreserviceimpl line no 94 ");
			return t;
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println("unable to featch theatre with name");
			return null;
		}
	}

	public List<Theatre> getTheatresByMovieSelected(int movieId,String location) {
		// TODO Auto-generated method stub
		
		String s = "select   t.* from movie m  inner join Shows s on s.movieid=m.id "
				+ "inner Join theatre t on t.id = s.theatreid where t.location=? and s.movieid=?";
		
		try {
			List<Theatre> theatreList = jt.query(s, new Object[] {location,movieId}, new Theatrerowmapper());
			
			
			List<Theatre> uniqueTheatreList =  new ArrayList<Theatre>();
			
			for(Theatre t:theatreList)
			{
				if(uniqueTheatreList.size()==0)
				{
					uniqueTheatreList.add(t);
				}
				else
				{
					int r =1;
					for(Theatre ut:uniqueTheatreList)
					{
						if(ut.getId()==t.getId())
							r=0;
					}
					
					if(r==1)
						uniqueTheatreList.add(t);
				}
			}
			
			
			return uniqueTheatreList;
			
		}
		catch(Exception e) {
			System.out.println("NO theatre retrived");
			return null;
		}
	}

	public Theatre getTheatreById(int id) {
		// TODO Auto-generated method stub
		String s ="select * from Theatre where id=?";
		try {
			Theatre queryForObject = jt.queryForObject(s,new Object[] {id},new Theatrerowmapper());
			return queryForObject;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			System.out.println("error at theatreserviceimpl line no 157 ");
			return null;
		}
		
	}


}
