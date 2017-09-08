package com.cgm.assignment5spring.domain;

import java.util.ArrayList;

public class MessageQueue {
	private ArrayList<Message> messages;
	
	public MessageQueue() {
		this.messages = new ArrayList<Message>();
	}

	public ArrayList<Message> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}
	
	public void addMessage(Message message) {
		this.messages.add(message);
	}
}
