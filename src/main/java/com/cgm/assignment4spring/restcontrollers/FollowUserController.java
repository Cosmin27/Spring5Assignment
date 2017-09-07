package com.cgm.assignment4spring.restcontrollers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cgm.assignment4spring.builders.ArtefactBuilder;
import com.cgm.assignment4spring.entities.Message;
import com.cgm.assignment4spring.entities.ServiceResponse;
import com.cgm.assignment4spring.entities.User;

@RestController
public class FollowUserController {
	@RequestMapping(value="/followUserRest/{username}", method=RequestMethod.PUT)
	public ServiceResponse follow(@PathVariable String username, HttpServletRequest request) {
		for(User user : ArtefactBuilder.userAccounts()) {
			if(user.getUsername().equals(username)) {
				user.addFriend((User) request.getSession().getAttribute("userAccount"));
				return new ServiceResponse();
			}
		}
		return new ServiceResponse("Error while following user. User not found.", 404);
	}
	
	@RequestMapping(value="/unfollowUserRest/{username}", method=RequestMethod.PUT)
	public ServiceResponse unfollow(@PathVariable String username, HttpServletRequest request) {
		for(User user : ArtefactBuilder.userAccounts()) {
			if(user.getUsername().equals(username)) {
				user.removeFriend((User) request.getSession().getAttribute("userAccount"));
				return new ServiceResponse();
			}
		}
		return new ServiceResponse("Error while unfollowing user. User not found.", 404);
	}
}
