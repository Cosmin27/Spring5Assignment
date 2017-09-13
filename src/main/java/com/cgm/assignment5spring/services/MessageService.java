package com.cgm.assignment5spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgm.assignment5spring.domain.Message;
import com.cgm.assignment5spring.domain.User;
import com.cgm.assignment5spring.dto.MessageQueue;
import com.cgm.assignment5spring.repository.MessageDAO;
import com.cgm.assignment5spring.repository.UserDAO;

@Service
public class MessageService {
	@Autowired
	UserDAO userDAO;
	@Autowired
	MessageDAO messageDAO;
	
	public MessageQueue getMessages(Integer id) {
		MessageQueue messageQueue = new MessageQueue();
		
		User user = userDAO.findById(id);
		List<Message> messages = user.getMessages();

		messageQueue.addMessages(messages);
		
		for(User friend : user.getFriends()) {
			messageQueue.addMessages(friend.getMessages());
		}
		
		return messageQueue;
	}
	
	public Message postMessage(Message message, Integer userID) {
		User user = userDAO.findById(userID);
		message.setMessageAuthor(user);
		messageDAO.save(message);
		return message;
	}
}
