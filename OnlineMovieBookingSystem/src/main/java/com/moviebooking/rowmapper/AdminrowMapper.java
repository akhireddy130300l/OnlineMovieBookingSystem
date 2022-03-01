package com.moviebooking.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.moviebooking.bean.Admin;

public class AdminrowMapper implements RowMapper<Admin> {

	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Admin adm =new Admin();
		adm.setId(rs.getInt(1));
		adm.setName(rs.getString(2));
		adm.setEmail(rs.getString(3));
		adm.setPhoneno(rs.getString(4));
		adm.setPassword(rs.getString(5));
		return adm;
	}

}
