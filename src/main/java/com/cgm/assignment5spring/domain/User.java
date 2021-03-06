package com.cgm.assignment5spring.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "sbs_users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "sbs_users_id_seq", sequenceName = "sbs_users_id_seq", allocationSize = 1)
	private int id;
	
	@Column(name = "user_email")
	private String user_email = "";
	
	@Column(name = "user_name", unique = true)
	private String user_name = "";
	
	@JsonIgnore
	@Column(name = "user_password")
	private String user_password = "";
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "sbs_friends", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_friend"))
	private List<User> friends;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "sbs_friends", joinColumns = @JoinColumn(name = "id_friend"), inverseJoinColumns = @JoinColumn(name = "id_user"))
	private List<User> friendOf;
	
	@JsonIgnore
	@OneToMany(mappedBy = "messageAuthor", fetch = FetchType.EAGER)
	private List<Message> messages;
	
	public User() {
		
	}

	@JsonIgnore
	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public User(String user_name, String user_password) {
		this.user_name = user_name;
		this.user_password = user_password;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	@JsonIgnore
	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}
	
	public void addFriend(User friend) {
		friends.add(friend);
	}
	
	public void removeFriend(User friend) {
		friends.remove(friend);
	}
	
	public boolean hasFriend(User user) {
		if(friends.contains(user)) {
			return true;
		}
		return false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object object) {
		if(object == null) {
			return false;
		}
		
		if(!(object instanceof User)) {
			return false;
		}
		
		if(object == this) {
			return true;
		}
		
		User user = (User) object;
		if(this.id == user.getId()) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return (int) id;
	}
}
