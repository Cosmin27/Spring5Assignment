package com.cgm.assignment5spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgm.assignment5spring.domain.User;
import com.cgm.assignment5spring.repository.UserDAO;

@Service
public class LoginService {
	@Autowired
	UserDAO userDAO;
	
	public boolean checkLogin(User user) {
		User dbUser = userDAO.getUserWithUsername(user.getUser_name());
		if(dbUser == null) {
			return false;
		}
		else {
			if(dbUser.getUser_password().equals(user.getUser_password())) {
				return true;
			}
			return false;
		}
	}
	
	public Integer getUserIDForUsername(String username) {
		return userDAO.getUserWithUsername(username).getId();
	}
}
