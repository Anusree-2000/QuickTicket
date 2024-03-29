package com.quickTicket.restdata.repository;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.quickTicket.restdata.model.User;

import org.springframework.jdbc.core.RowMapper;

@Repository
public class LoginDAOImpl 
{
	@Autowired
	 private NamedParameterJdbcTemplate jdbcTemplate;
	
	public User getUserLogin(User user)
	{
		String query = "Select password from tbl_user where contact_no = :contactNo";
	    SqlParameterSource parameterSource = new MapSqlParameterSource("contactNo", user.getContactNo());
	    
	    try 
	    {
	    	return jdbcTemplate.queryForObject(query, parameterSource, new RowMapper<User>() {
	            @Override
	            public User mapRow(ResultSet rs, int rowNum) throws SQLException
	            {
	            	User user = new User();
	            	user.setPassword(rs.getString("password")); //here password is the "password" column in tbl_user
	            	return user;
	            }
	        });
	    } 
	    catch (EmptyResultDataAccessException e) 
	    {
	        return null;
	    }
		
	}

}
