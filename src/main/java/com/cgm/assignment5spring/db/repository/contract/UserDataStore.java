package com.cgm.assignment5spring.db.repository.contract;

import java.util.List;

import com.cgm.assignment5spring.domain.User;

public interface UserDataStore {
	void storeUser(User user);
	List<User> readUser();
}
