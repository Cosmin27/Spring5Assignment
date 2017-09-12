package com.cgm.assignment5spring.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cgm.assignment5spring.domain.User;

@Repository
public class UserDAO extends AbstractDAO<User>{
	protected UserDAO() {
		super(User.class);
	}
	
	@Transactional
	public List<User> loginAndGetID(User user) {
		//System.out.println((List<User>) em().createQuery(new StringBuilder().append("SELECT user_name FROM ").append((User.class).getCanonicalName()).append(" u WHERE u.user_name = '").append(user.getUser_name()).append("' AND u.user_password = '").append(user.getUser_password()).append("'").toString()).getResultList());
		return (List<User>) em().createQuery(new StringBuilder().append("SELECT id FROM ").append((User.class).getCanonicalName()).append(" u WHERE u.user_name = '").append(user.getUser_name()).append("' AND u.user_password = '").append(user.getUser_password()).append("'").toString()).getResultList();
	}
	
	@Transactional
	public Map<String, Boolean> getAllUsers(User user) {
		Map<String, Boolean> users = new HashMap<String, Boolean>();
		List<User> usersList = (List<User>) em().createQuery(new StringBuilder().append("SELECT user FROM ").append((User.class).getCanonicalName()).append(" user WHERE user.id != ").append(user.getId()).toString()).getResultList();
		System.out.println("TEST: " + user.getFriends().contains(super.findById(4)));
		for(User userFromList : usersList) {
			if(user.getFriends().contains(userFromList)) {
				users.put(userFromList.getUser_name(), true);
				//System.out.println(userFromList.getUser_name() + "  true");
			}
			else {
				users.put(userFromList.getUser_name(), false);
				//System.out.println(userFromList.getUser_name() + "   false");
			}
		}
		return users;
	}
	
	@Transactional
	public Map<String, Boolean> getAllUsersSearch(User user, String search) {
		Map<String, Boolean> users = new HashMap<String, Boolean>();
		List<User> usersList = (List<User>) em().createQuery(new StringBuilder().append("SELECT user FROM ").append((User.class).getCanonicalName()).append(" user WHERE user.id != ").append(user.getId()).append(" AND user.user_name LIKE '%").append(search).append("%'").toString()).getResultList();
		System.out.println("TEST: " + user.getFriends().contains(super.findById(4)));
		for(User userFromList : usersList) {
			if(user.getFriends().contains(userFromList)) {
				users.put(userFromList.getUser_name(), true);
				//System.out.println(userFromList.getUser_name() + "  true");
			}
			else {
				users.put(userFromList.getUser_name(), false);
				//System.out.println(userFromList.getUser_name() + "   false");
			}
		}
		return users;
	}
	
	@Transactional
	public List<User> getUserWithUsername(String username) {
		return (List<User>) em().createQuery(new StringBuilder().append("SELECT u FROM ").append((User.class).getCanonicalName()).append(" u WHERE u.user_name = '").append(username).append("'").toString()).getResultList();
	}
}
