package com.cgm.assignment4spring.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cgm.assignment4spring.builders.ArtefactBuilder;
import com.cgm.assignment4spring.entities.User;

@Controller
public class FollowController {
	@RequestMapping(value = "/followUser/{username}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView followUser(@PathVariable("username") String username, Map model, HttpServletRequest request) {
		for(User user : ArtefactBuilder.userAccounts()) {
			if(user.getUsername().equals(username)) {
				user.addFriend((User) request.getSession().getAttribute("userAccount"));
			}
		}
		//System.out.println("USER: " + username);
		return new ModelAndView("redirect:/friends", model);
		
	}
	
	@RequestMapping(value = "/unfollowUser/{username}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView unfollowUser(@PathVariable("username") String username, Map model, HttpServletRequest request) {
		for(User user : ArtefactBuilder.userAccounts()) {
			if(user.getUsername().equals(username)) {
				user.removeFriend((User) request.getSession().getAttribute("userAccount"));
			}
		}
		//System.out.println("USER: " + username);
		return new ModelAndView("redirect:/friends", model);
		
	}
}
