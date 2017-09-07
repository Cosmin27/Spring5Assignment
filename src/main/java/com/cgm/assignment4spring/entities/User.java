package com.cgm.assignment4spring.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {
	private String username = "";
	@JsonIgnore
	private String password = "";
	@JsonIgnore
	private boolean logged = false;
	@JsonIgnore
	private List<User> friends;
	
	private ArrayList<String> friendsAsStrings = new ArrayList<String>();

	public User() {
		this.friends = new ArrayList<User>();
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.friends = new ArrayList<User>();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLogged() {
		return logged;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}

	@JsonIgnore
	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	public void addFriend(User user) {
		if (!this.friends.contains(user)) {
			this.friends.add(user);
			this.friendsAsStrings.add(user.getUsername());
			user.addFriend(this);
		}
	}
	
	public void removeFriend(User user) {
		if(!this.friends.isEmpty()) {
			if(this.friends.contains(user)) {
				this.friends.remove(user);
				this.friendsAsStrings.remove(user.getUsername());
				user.removeFriend(this);
			}
		}
	}
	
	
	public ArrayList<String> getFriendsAsStrings() {
		return friendsAsStrings;
	}
}
