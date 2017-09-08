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
	public boolean checkLogin(User user) {
		return ((List<User>) em().createQuery(new StringBuilder().append("SELECT entity FROM ").append((User.class).getCanonicalName()).append(" entity ").toString()).getResultList()).size() == 1;
	}
}
