package com.moviebooking.service;

import java.util.List;

import com.moviebooking.bean.Theatre;

public interface Theatreservice {
 public List<Theatre> allTheatreLoaction();
 public int addTheatre(String theatreName,String theatreLocation,int noofSeats,int noofrows);
 public int removeTheatre(int TheatreId,String TheatreName);
 public Theatre getTheatre(String theatreName);
 public List<Theatre> getTheatresByMovieSelected(int movieId,String location);
 public Theatre getTheatreById(int id);
}
