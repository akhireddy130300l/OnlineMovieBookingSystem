package com.moviebooking.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.moviebooking.bean.Seat;

public class SeatrowMapper implements RowMapper<Seat> {

	public Seat mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Seat seat = new Seat();
		seat.setId(rs.getInt(1));
		seat.setSeatrow(rs.getString(2));
		seat.setSeatno(rs.getInt(3));
		seat.setTheatreid(rs.getInt(4));
		return seat;
	}

}
