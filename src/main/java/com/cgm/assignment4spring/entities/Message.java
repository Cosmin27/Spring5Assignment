package com.cgm.assignment4spring.entities;

public class Message {
	private String messageText = "";
	private User messageAuthor;

	public Message() {

	}

	public Message(User messageAuthor, String messageText) {
		this.messageAuthor = messageAuthor;
		this.messageText = messageText;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public User getMessageAuthor() {
		return messageAuthor;
	}

	public void setMessageAuthor(User messageAuthor) {
		this.messageAuthor = messageAuthor;
	}
}
