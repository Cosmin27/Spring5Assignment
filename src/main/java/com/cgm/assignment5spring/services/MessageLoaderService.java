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
public class MessageLoaderService {
	@Autowired
	UserDAO userDAO;
	@Autowired
	MessageDAO messageDAO;
	
	public MessageQueue getMessages(Integer id) {
		MessageQueue messageQueue = new MessageQueue();
		
		User user = userDAO.findById(id);
		//System.out.println(user.getUser_name() + "    " + user.getId());
		//System.out.println("here " + messageDAO.em().createQuery("SELECT msg FROM " + (Message.class).getCanonicalName() + " msg WHERE msg.messageAuthor.id = :userId").setParameter("userId", user.getId()).getResultList());
		List<Message> messages = user.getMessages();
		System.out.println(messages);
		
		//System.out.println();

		messageQueue.addMessages(messages);
		System.out.println("FRIENDS: " + user.getFriends().size());
		System.out.println(user.getFriends());
		for(User friend : user.getFriends()) {
			System.out.println(friend.getMessages());
			messageQueue.addMessages(friend.getMessages());
		}
		
		return messageQueue;
	}
}
