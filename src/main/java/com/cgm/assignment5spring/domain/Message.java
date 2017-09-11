package com.cgm.assignment5spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "sbs_messages")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "sbs_messages_id_seq", sequenceName = "sbs_messages_id_seq", allocationSize = 1)
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_user")
	private User messageAuthor;
	
	@Column(name = "messagetext")
	private String messageText = "";

	public Message() {

	}

	public User getMessageAuthor() {
		return messageAuthor;
	}

	public void setMessageAuthor(User messageAuthor) {
		this.messageAuthor = messageAuthor;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
}
