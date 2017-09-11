package com.cgm.assignment5spring.repository;

import java.util.List;

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
	
	
}
