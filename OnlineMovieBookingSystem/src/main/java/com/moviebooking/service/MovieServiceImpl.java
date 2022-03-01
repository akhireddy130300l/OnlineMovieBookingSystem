package com.moviebooking.service;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.moviebooking.bean.Movie;
import com.moviebooking.rowmapper.MovierowMapper;

public class MovieServiceImpl implements MovieService {
	
	private JdbcTemplate jt = null;
	
	
	
	public MovieServiceImpl() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/moviedb8?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("priyatham");
        jt = new JdbcTemplate(dataSource);
	}
	
	

	public int addMovietoDB(String name, String actors, String Director,String postername,byte[] bytes) {
		// TODO Auto-generated method stub
		String query = "insert into Movie(name,actors,director,postername,poster) values(?,?,?,?,?)";
		int r;
		
		try {
		r =jt.update(query,new Object[] {name,actors,Director,postername,bytes});	
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println("Unable to add movie");
			return 0;
		}
		
		if(r!=0) {
			return 1;
		}
		else {
			return 0;
		}
	}

	public List<Movie> allMovieList() {
		// TODO Auto-generated method stub
		String getquery ="select * from Movie";
		try {
			List<Movie> movielist = jt.query(getquery, new MovierowMapper());
			
			for(Movie m:movielist)
			{
				System.out.println(m);
			}
			return movielist;
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println("Unable to fetch details from the movietable");
			return null;
		}
		
		
		
	}



	public int deleteMovie(int id) {
		// TODO Auto-generated method stub
		
		String s = "delete from Movie where id=?";
		int r;
		
		try {
		r =jt.update(s,new Object[] {id});	
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println("Unable to add movie");
			return 0;
		}
		if(r!=0) {
			return 1;
		}
		else {
			return 0;
		}
	}



	public List<Movie> movielistByLocation(String locationselected) {
		// TODO Auto-generated method stub
		String s ="select  m.* from movie m inner join Shows s on s.movieid=m.id "
				+ "inner Join theatre t on t.id = s.theatreid where t.location=?;";
		try {
			List<Movie> movielistByLocation = jt.query(s, new Object[] {locationselected}, new MovierowMapper());
			
//			for(Movie m:movielistByLocation)
//			{
//				System.out.println(m.toString());
//			}
//			System.out.println("===========----==========");
			List<Movie> uniqueMovieList = new ArrayList<Movie>();
			for(Movie movie:movielistByLocation)
			{
				if(uniqueMovieList.size()==0)
				{
					uniqueMovieList.add(movie);
				}
				else {
					int r = 1;
					for(Movie mv:uniqueMovieList)
					{
					
						if(mv.getId()==movie.getId())
						{
							r=0;
							break;
						}
					}
					if(r==1)
					{
						uniqueMovieList.add(movie);
					}
				}
			}
			
//			for(Movie m:uniqueMovieList)
//			{
//				System.out.println(m.toString());
//			}
			
			return uniqueMovieList;
		}
		catch(Exception e)
		{
			System.out.println("unable to retrive the data from the location selected(MovieServiceImpl line 150)");
			return null;
		}
		//return null;
	}



	public Movie getMoviebyId(int id) {
		// TODO Auto-generated method stub
		
		String s = "select * from Movie where id=?";
		try
		{
			Movie queryForObject = jt.queryForObject(s,new Object[] {id},new MovierowMapper());
			return queryForObject;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			System.out.println("unable to retrive movie by id line no 168 in movieserviceimpl");
			return null;
		}
	}



	public List<Movie> latestmovies(int size) {
		// TODO Auto-generated method stub
		String s = "select * from Movie order by id desc limit ?";
		try {
			List<Movie> query = jt.query(s, new Object[] {size},new MovierowMapper());
			return query;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			
			System.out.println("Movie Service Impl line no 187");
			return null;
		}
	}

}
