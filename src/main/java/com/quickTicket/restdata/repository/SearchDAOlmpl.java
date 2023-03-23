package com.quickTicket.restdata.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.quickTicket.restdata.model.BusRequest;
import com.quickTicket.restdata.model.BusResponse;

@Repository
public class SearchDAOlmpl 
{
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public BusResponse getBusResonseDetailsByUser(BusRequest busRequest) {
		String query = "select * from customer where email = :email";
        SqlParameterSource parameterSource = new MapSqlParameterSource();

        try {
            return jdbcTemplate.queryForObject(query, parameterSource, new RowMapper<BusResponse>() {
                @Override
                public BusResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
                	BusResponse person = new BusResponse();
                    return person;
                }
            });
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
		
	
	}
	

}
