package com.cgm.assignment5spring.restcontrollers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cgm.assignment5spring.domain.Message;
import com.cgm.assignment5spring.domain.User;
import com.cgm.assignment5spring.dto.ServiceResponse;
import com.cgm.assignment5spring.repository.UserDAO;
import com.cgm.assignment5spring.services.FollowUserService;

@RestController
public class FollowUserController {
	@Autowired
	FollowUserService followUserService;

	@RequestMapping(value = "/followUserRest/{username}", method = RequestMethod.PUT)
	public ServiceResponse follow(@PathVariable String username, HttpServletRequest request) {
		if (followUserService.followUser((Integer) request.getSession().getAttribute("userID"), username)) {
			return new ServiceResponse();
		}
		
		return new ServiceResponse("Error while following user. User not found.", 404);

	}

	@RequestMapping(value = "/unfollowUserRest/{username}", method = RequestMethod.PUT)
	public ServiceResponse unfollow(@PathVariable String username, HttpServletRequest request) {
		if (followUserService.unfollowUser((Integer) request.getSession().getAttribute("userID"), username)) {
			return new ServiceResponse();
		}

		return new ServiceResponse("Error while unfollowing user. User not found.", 404);
	}
}
