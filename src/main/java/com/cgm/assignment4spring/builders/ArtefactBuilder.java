package com.cgm.assignment4spring.builders;

import java.util.ArrayList;

import com.cgm.assignment4spring.entities.Message;
import com.cgm.assignment4spring.entities.MessageQueue;
import com.cgm.assignment4spring.entities.User;
import com.cgm.assignment4spring.entities.Users;

public class ArtefactBuilder {
	private static Users users = new Users();
	private static MessageQueue messageQueue;
	
	private static void createUserAccountsAndMessages() {
		User user1 = new User("username", "admin");
		User user2 = new User("username1", "admin1");
		User user3 = new User("username2", "admin2");
		User user4 = new User("username3", "admin3");
		
		Message message1 = new Message(user1, "Hello, this is username.");
		Message message2 = new Message(user2, "Hello, this is username1.");
		Message message3 = new Message(user1, "Hello, this is username AGAIN.");
		Message message4 = new Message(user3, "Hello, this is username2.");
		Message message5 = new Message(user4, "Hello, this is username3.");
		
		
		user1.addFriend(user2);
		user1.addFriend(user3);
		
		messageQueue = new MessageQueue();
		messageQueue.addMessage(message1);
		messageQueue.addMessage(message2);
		messageQueue.addMessage(message3);
		messageQueue.addMessage(message4);
		messageQueue.addMessage(message5);
		
		users.addUser(user1);
		users.addUser(user2);
		users.addUser(user3);
		users.addUser(user4);
	}
	
	public static ArrayList<User> userAccounts() {
		if(users.getNumberOfUsers() == 0) {
			createUserAccountsAndMessages();
		}
		return users.getUsers();
	}
	
	public static ArrayList<Message> getMessages() {
		if(users.getNumberOfUsers() == 0) {
			createUserAccountsAndMessages();
		}
		return messageQueue.getMessages();
	}
	
	public static MessageQueue getMessageQueue() {
		return messageQueue;
	}
	
	public static Users getUsers() {
		return users;
	}
}
