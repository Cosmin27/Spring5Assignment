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

@RestController
public class FollowUserController {
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value="/followUserRest/{id}", method=RequestMethod.PUT)
	public ServiceResponse follow(@PathVariable Integer id, HttpServletRequest request) {
		/*for(User user : ArtefactBuilder.userAccounts()) {
			if(user.getUsername().equals(username)) {
				user.addFriend((User) request.getSession().getAttribute("userAccount"));
				return new ServiceResponse();
			}
		}*/
		User newFriend = userDAO.findById(id);
		User currentUser = userDAO.findById((Integer) request.getSession().getAttribute("userID"));
		currentUser.addFriend(newFriend);
		userDAO.save(currentUser);
		return new ServiceResponse("Error while following user. User not found.", 404);
	}
	
	@RequestMapping(value="/unfollowUserRest/{id}", method=RequestMethod.PUT)
	public ServiceResponse unfollow(@PathVariable Integer id, HttpServletRequest request) {
		/*for(User user : ArtefactBuilder.userAccounts()) {
			if(user.getUsername().equals(username)) {
				user.removeFriend((User) request.getSession().getAttribute("userAccount"));
				return new ServiceResponse();
			}
		}*/
		User oldFriend = userDAO.findById(id);
		User currentUser = userDAO.findById((Integer) request.getSession().getAttribute("userID"));
		if(currentUser.getFriends().contains(oldFriend)) {
			currentUser.removeFriend(oldFriend);
		}
		userDAO.save(currentUser);
		return new ServiceResponse("Error while unfollowing user. User not found.", 404);
	}
}
