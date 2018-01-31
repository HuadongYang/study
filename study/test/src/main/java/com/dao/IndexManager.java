package com.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;

@Component
public class IndexManager {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	DataSource dataSource;
	
	public String queryNameById(Integer id){
		jdbcTemplate.setDataSource(dataSource);
		String sql = "select name from school.student where id=" + id;
		return jdbcTemplate.queryForObject(sql, String.class);
	}
	
}
