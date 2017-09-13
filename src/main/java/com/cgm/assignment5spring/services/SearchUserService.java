package com.cgm.assignment5spring.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgm.assignment5spring.repository.UserDAO;

@Service
public class SearchUserService {
	@Autowired
	UserDAO userDAO;
	
	public Map<String, Boolean> searchForUsername(Integer currentUserID, String usernameToSearchFor) {
		return userDAO.getAllUsersSearch(userDAO.findById(currentUserID), usernameToSearchFor);
	}
	
	public Map<String, Boolean> getUsers(Integer currentUserID) {
		return userDAO.getAllUsers(userDAO.findById(currentUserID));
	}
}
