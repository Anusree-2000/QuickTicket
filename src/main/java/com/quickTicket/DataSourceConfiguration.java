package com.quickTicket;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class DataSourceConfiguration.
 */
@Configuration
public class DataSourceConfiguration {

    /** The data source. */
	@Autowired
    private DataSource dataSource;

    /**
     * Primary jdbc template.
     *
     * @return the named parameter jdbc template
     */
   @Bean
    public NamedParameterJdbcTemplate primaryJdbcTemplate() {
	   System.out.println("named paramter");
        return new NamedParameterJdbcTemplate(dataSource);
    }

}
