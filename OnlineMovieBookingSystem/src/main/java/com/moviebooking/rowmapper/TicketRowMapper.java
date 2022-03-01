package com.moviebooking.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.moviebooking.bean.Ticket;

public class TicketRowMapper implements RowMapper<Ticket> {

	public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Ticket ticket =  new Ticket();
		ticket.setId(rs.getInt(1));
		ticket.setDateofbooking(rs.getString(2));
		ticket.setSeatno(rs.getString(3));
		ticket.setMovieid(rs.getInt(4));
		ticket.setShowid(rs.getInt(5));
		ticket.setTheatreid(rs.getInt(6));
		ticket.setPrice(rs.getInt(7));
		return ticket;
	}

}
