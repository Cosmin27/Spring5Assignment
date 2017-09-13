package com.cgm.assignment5spring.dto;

public class UserDTO {
	private int userID;
	private String username;
	
	public UserDTO() {
		
	}
	
	public UserDTO(int userID, String username) {
		this.userID = userID;
		this.username = username;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
