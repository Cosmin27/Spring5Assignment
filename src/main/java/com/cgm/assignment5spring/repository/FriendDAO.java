package com.cgm.assignment5spring.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cgm.assignment5spring.domain.Friend;
import com.cgm.assignment5spring.domain.Message;
import com.cgm.assignment5spring.domain.User;

@Repository
public class FriendDAO extends AbstractDAO<Friend>{
	public FriendDAO() {
		super(Friend.class);
	}
	
	@Transactional
	public Map<User, Boolean> getUsers(Integer currentUserID) {
		List<User> users = em().createQuery("SELECT user FROM " + (User.class).getCanonicalName() + " user WHERE user.id != :userId").setParameter("userId", currentUserID).getResultList();
		for(User user: users) {
			System.out.println(em().createQuery("SELECT friend FROM " + (Friend.class).getCanonicalName() + " friend WHERE friend.id_user = :userId").setParameter("userId", currentUserID).getSingleResult());
			System.out.println("User: " + user.getUser_name());
		}
		
		
		return null;
	}
}
