package com.spring.jdbc.SpringJDBC.Dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.SpringJDBC.Entity.Student;

public class StudentDaoImpl implements StudentDao{
	
	
	private JdbcTemplate jdbcTemplate;
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public int insert(Student student) {
		
        String q = "insert into student (id,name,city) values (?,?,?)";
        int update = this.jdbcTemplate.update(q,student.getId(), student.getName(), student.getCity());
		return update;
	}

}
