package com.cgm.assignment5spring.restcontrollers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cgm.assignment5spring.domain.MessageQueue;
import com.cgm.assignment5spring.domain.User;
import com.cgm.assignment5spring.repository.UserDAO;

@RestController
public class SearchUserController {
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value="/search/{username}", method=RequestMethod.GET, produces = "application/json")
	public Map<String, Boolean> searchForUsername(@PathVariable String username, HttpServletRequest request) {
		Map<String, Boolean> users = userDAO.getAllUsersSearch(userDAO.findById((Integer) request.getSession().getAttribute("userID")), username);
		/*for(User user : ArtefactBuilder.userAccounts()) {
			if(user.getUsername().toLowerCase().contains(username.toLowerCase()) && !user.getUsername().equals(request.getSession().getAttribute("usernameString"))) {
				users.add(user);
			}
		}*/
		return users;
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET, produces = "application/json")
	public Map<String, Boolean> getUsers(HttpServletRequest request) {
		Map<String, Boolean> users = userDAO.getAllUsers(userDAO.findById((Integer) request.getSession().getAttribute("userID")));
		
		//users.addAll(ArtefactBuilder.userAccounts());
		//users.remove(request.getSession().getAttribute("userAccount"));
		return users;
	}
}
