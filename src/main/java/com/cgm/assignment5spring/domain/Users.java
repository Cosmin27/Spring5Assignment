package com.cgm.assignment5spring.domain;

import java.util.ArrayList;

public class Users {
	private ArrayList<User> users;
	public Users() {
		users = new ArrayList<User>();
	}
	
	public void addUser(User user) {
		this.users.add(user);
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}
	
	public User getUserWithUsername(String username) {
		for(User user : users) {
			if(user.getUser_name().equals(username)) {
				return user;
			}
		}
		return new User();
	}
	
	public int getNumberOfUsers() {
		return users.size();
	}
}
