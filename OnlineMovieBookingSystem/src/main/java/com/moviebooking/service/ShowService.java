package com.moviebooking.service;

import java.util.List;

import com.moviebooking.bean.Shows;
import com.moviebooking.bean.Theatre;

public interface ShowService {
	public int addShow(String movieStartTime,int MovieId,int TheatreId);
	public List<Shows> allShows();
	public int removeShow(int id);
	public int updateShow(int showId,int MovieId);
	public List<Shows> allShowsbyTheatre(List<Theatre> theatresByMovieSelected, int movieId);
	public Shows showTimeById(int sId);
}
