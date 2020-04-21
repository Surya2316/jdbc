package com.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class OwnerDAO
{
    @Autowired
	private DataSource datasource;
	private JdbcTemplate jdbcTemplate;
	
	public int getIdByName(String name) 
    {
        int i=0;
		String sql = "select id from owner where name=?";
        i = jdbcTemplate.queryForObject(sql,Integer.class,name);
        System.out.println("hii1");
        return i;
	}
	
    public List<Owner> getAllOwners()
    {
        ArrayList<Owner> list = (ArrayList<Owner>) jdbcTemplate.query("SELECT * FROM owner", new RowMapper<Owner>() {

			public Owner mapRow(ResultSet rs, int rowNum) throws SQLException 
            {
				 Owner ow = new Owner();

				ow.setName(rs.getString("name"));
				ow.setPassword(rs.getString("password"));
				ow.setEmailId(rs.getString("emailId"));
				ow.setMobileNumber(rs.getString("mobileNumber"));

				return ow;
			}

		});
		return list;
    }
}
