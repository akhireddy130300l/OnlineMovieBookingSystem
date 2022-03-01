package com.moviebooking.service;

import java.util.List;

import com.moviebooking.bean.Movie;
import com.moviebooking.bean.Seat;
import com.moviebooking.bean.Theatre;

public interface Seatservice {
public int addseattoDB(Theatre theatre);
public int removeSeatsofTheatre(int TheatreId);
public Movie getMovieIdbyShowId(int showId);
public Theatre getTheatrebyShowId(int showId);
public List<Seat> seatsByTheatre(Theatre theatre);
public Seat getSeatBySeatId(int sId);
}
