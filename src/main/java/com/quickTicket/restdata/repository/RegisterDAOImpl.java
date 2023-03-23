package com.quickTicket.restdata.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.quickTicket.restdata.model.User;

@Repository
public class RegisterDAOImpl 
{
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public void saveUserDetails(User user) throws Exception
	{
		System.out.println("Full name"+ user.getUserName());
		String query = "Insert into tbl_user (user_name, contact_no, password, email_id) VALUES(:username,:contact_no,:password,:email_id)";
		
        SqlParameterSource parameterSource = new MapSqlParameterSource("username", user.getUserName())
        		.addValue("contact_no", user.getContactNo()).addValue("password",user.getPassword()).addValue("email_id",user.getEmailId());

        try {
        	jdbcTemplate.update(query, parameterSource);
        } 
        catch (DataAccessException e) 
        {
        	e.printStackTrace();
        	throw new Exception();
        }
	}

}
