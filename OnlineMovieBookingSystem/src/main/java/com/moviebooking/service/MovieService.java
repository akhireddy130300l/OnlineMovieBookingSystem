package com.moviebooking.service;

import java.util.List;

import com.moviebooking.bean.Movie;

public interface MovieService {
	public int  addMovietoDB(String name,String actors,String Director,String postername,byte[] bytes);
	public List<Movie> allMovieList(); 
	public int deleteMovie(int id);
	public List<Movie> movielistByLocation(String locationselected);
	public Movie getMoviebyId(int id);
	public List<Movie> latestmovies(int size);

}
