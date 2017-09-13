package com.cgm.assignment5spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgm.assignment5spring.domain.User;
import com.cgm.assignment5spring.repository.UserDAO;

@Service
public class FollowUserService {
	@Autowired
	UserDAO userDAO;
	
	public boolean followUser(Integer currentUserID, String usernameToFollow) {
		User currentUser = userDAO.findById(currentUserID);
		User newFriend = userDAO.getUserWithUsername(usernameToFollow);
		
		if(currentUser == null || newFriend == null) {
			return false;
		}
		
		currentUser.addFriend(newFriend);
		userDAO.update(currentUser);
		
		return true;
	}
	
	public boolean unfollowUser(Integer currentUserID, String usernameToUnFollow) {
		User currentUser = userDAO.findById(currentUserID);
		User oldFriend = userDAO.getUserWithUsername(usernameToUnFollow);
		
		if(currentUser == null || oldFriend == null) {
			return false;
		}
		currentUser.removeFriend(oldFriend);
		userDAO.update(currentUser);
		
		return true;
	}
}
