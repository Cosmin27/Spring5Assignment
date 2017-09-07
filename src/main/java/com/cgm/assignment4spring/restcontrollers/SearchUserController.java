package com.cgm.assignment4spring.restcontrollers;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cgm.assignment4spring.builders.ArtefactBuilder;
import com.cgm.assignment4spring.entities.MessageQueue;
import com.cgm.assignment4spring.entities.User;

@RestController
public class SearchUserController {
	@RequestMapping(value="/search/{username}", method=RequestMethod.GET, produces = "application/json")
	public ArrayList<User> searchForUsername(@PathVariable String username, HttpServletRequest request) {
		ArrayList<User> users = new ArrayList<User>();
		for(User user : ArtefactBuilder.userAccounts()) {
			if(user.getUsername().toLowerCase().contains(username.toLowerCase()) && !user.getUsername().equals(request.getSession().getAttribute("usernameString"))) {
				users.add(user);
			}
		}
		return users;
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET, produces = "application/json")
	public ArrayList<User> getUsers(HttpServletRequest request) {
		ArrayList<User> users = new ArrayList<User>();
		users.addAll(ArtefactBuilder.userAccounts());
		users.remove(request.getSession().getAttribute("userAccount"));
		return users;
	}
}
