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
	
	@Column(name = "user_name")
	private String user_name = "";
	
	@JsonIgnore
	@Column(name = "user_password")
	private String user_password = "";
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name = "sbs_friends", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_friend"))
	private List<User> friends = new ArrayList<User>();
	
	public User() {
		
	}

	public User(String username, String password) {
		this.user_name = username;
		this.user_password = password;
	}

	public String getUsername() {
		return user_name;
	}

	public void setUsername(String username) {
		this.user_name = username;
	}

	public String getPassword() {
		return user_password;
	}

	public void setPassword(String password) {
		this.user_password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserEmail() {
		return user_email;
	}

	public void setUserEmail(String user_email) {
		this.user_email = user_email;
	}
}
