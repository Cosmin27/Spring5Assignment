package com.cgm.assignment5spring.db.repository.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.cgm.assignment5spring.domain.User;

public class UserResultSetExtractor implements ResultSetExtractor<User> {
	@Override
	public User extractData(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setUsername(rs.getString("user_name"));
		user.setPassword(rs.getString("user_password"));
		user.setUserEmail(rs.getString("user_email"));
		
		return user;
	}
}
