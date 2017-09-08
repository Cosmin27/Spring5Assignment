package com.cgm.assignment5spring.db.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.cgm.assignment5spring.db.repository.contract.UserDataStore;
import com.cgm.assignment5spring.db.repository.utils.UserRowMapper;
import com.cgm.assignment5spring.domain.User;

@Repository("dbUserDAO")
@EnableTransactionManagement
public class DBUserDAO implements UserDataStore {
	private SimpleJdbcInsert insertUser;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		insertUser = new SimpleJdbcInsert(dataSource).withTableName("sbs_users").usingGeneratedKeyColumns("id");
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Transactional
	public void storeUser(User user) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("user_name", user.getUsername());
		parameters.put("user_password", user.getPassword());
		parameters.put("user_email", user.getUserEmail());
		
		try {
			insertUser.execute(parameters);
			System.out.println("User added.");
		} catch (DataAccessException dae) {
			System.out.println("Database error occured: " + dae.getMessage());
		}
	}
	
	public List<User> readUser() {
		StringBuilder selectStatement = new StringBuilder();
		selectStatement.append("SELECT * FROM ").append("sbs_users");
		
		List<User> users = null;
		try {
			users = jdbcTemplate.query(selectStatement.toString(), new Object[] {}, new UserRowMapper());
		} catch (DataAccessException dae) {
			System.out.println("Database error occured: " + dae.getMessage());
		}
		
		return users;
	}
}
