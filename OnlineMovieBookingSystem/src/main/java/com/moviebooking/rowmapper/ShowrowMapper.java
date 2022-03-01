package com.moviebooking.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.moviebooking.bean.Shows;

public class ShowrowMapper implements RowMapper<Shows> {

	public Shows mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Shows s = new Shows();
		s.setId(rs.getInt(1));
		s.setStarttime(rs.getString(2));
		s.setMovieid(rs.getInt(3));
		s.setTheatreid(rs.getInt(4));
		return s;
	}

}
