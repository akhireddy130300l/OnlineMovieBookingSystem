package com.moviebooking.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.moviebooking.bean.Movie;

public class MovierowMapper implements RowMapper<Movie> {

	public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Movie movie = new Movie();
		movie.setId(rs.getInt(1));
		movie.setName(rs.getString(2));
		movie.setActors(rs.getString(3));
		movie.setDirector(rs.getString(4));
		movie.setPostername(rs.getString(5));
		movie.setPoster(rs.getBlob(6));
		return movie;
	}

}
