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

import com.cgm.assignment5spring.domain.User;
import com.cgm.assignment5spring.dto.MessageQueue;
import com.cgm.assignment5spring.repository.UserDAO;
import com.cgm.assignment5spring.services.SearchUserService;

@RestController
public class SearchUserController {
	@Autowired
	SearchUserService searchUserService;
	
	@RequestMapping(value="/search/{username}", method=RequestMethod.GET, produces = "application/json")
	public Map<String, Boolean> searchForUsername(@PathVariable String username, HttpServletRequest request) {
		return searchUserService.searchForUsername((Integer) request.getSession().getAttribute("userID"), username);
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET, produces = "application/json")
	public Map<String, Boolean> getUsers(HttpServletRequest request) {
		return searchUserService.getUsers((Integer) request.getSession().getAttribute("userID"));
	}
}
