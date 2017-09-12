package com.cgm.assignment5spring.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cgm.assignment5spring.domain.Message;
import com.cgm.assignment5spring.domain.MessageQueue;
import com.cgm.assignment5spring.domain.User;
import com.cgm.assignment5spring.repository.MessageDAO;
import com.cgm.assignment5spring.repository.UserDAO;

@RestController
public class MessageLoaderController {
	@Autowired
	UserDAO userDAO;
	@Autowired
	MessageDAO messageDAO;

	@RequestMapping(value = "/messages/{id}", method = RequestMethod.GET, produces = "application/json")
	public MessageQueue getMessages(@PathVariable Integer id) {
		// System.out.println("HERE!!!");
		MessageQueue messageQueue = new MessageQueue();

		User user = userDAO.findById(id);
		//System.out.println(user.getUser_name() + "    " + user.getId());
		//System.out.println("here " + messageDAO.em().createQuery("SELECT msg FROM " + (Message.class).getCanonicalName() + " msg WHERE msg.messageAuthor.id = :userId").setParameter("userId", user.getId()).getResultList());
		List<Message> messages = user.getMessages();
		
		//System.out.println();

		messageQueue.addMessages(messages);
		
		for(User friend : user.getFriends()) {
			messageQueue.addMessages(friend.getMessages());
		}
		//System.out.println("Messages: " + messageQueue.getMessages().size());

		/*
		 * User currentUser = ArtefactBuilder.getUsers().getUserWithUsername(username);
		 * for(Message message : ArtefactBuilder.getMessageQueue().getMessages()) {
		 * if(message.getMessageAuthor().getUsername().equals(username) ||
		 * currentUser.getFriendsAsStrings().contains(message.getMessageAuthor().
		 * getUsername())) { messageQueue.addMessage(message); } }
		 */

		return messageQueue;
	}
}
