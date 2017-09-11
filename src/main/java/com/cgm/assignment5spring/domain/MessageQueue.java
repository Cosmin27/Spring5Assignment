package com.cgm.assignment5spring.domain;

import java.util.ArrayList;
import java.util.List;

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
	
	public void addMessages(List<Message> messages) {
		this.messages.addAll(messages);
	}
}
