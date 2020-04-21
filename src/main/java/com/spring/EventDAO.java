package com.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class EventDAO 
{
    
    @Autowired
    OwnerDAO ownerDAO;
	
	private DataSource datasource;
	private JdbcTemplate jdbcTemplate;
	
	public void createUser(String name,String eventName) 
    {
       int i =1;
       int a =  jdbcTemplate.update("insert into event (eventid, user, eventName) values (?, ?, ?)",i, name , eventName);
	   if(a>0)
       {
           System.out.println("The event registration is done successfully");
           i++;
       }
    }
	
	public int getIdByEventName(String eventName) 
    {
        int i=0;
	    String sql = "select id from owner where name=?";
        i = jdbcTemplate.queryForObject(sql,Integer.class,eventName);
        return i;	
    }
}