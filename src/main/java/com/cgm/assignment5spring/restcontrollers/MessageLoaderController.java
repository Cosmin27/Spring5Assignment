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
import com.cgm.assignment5spring.services.MessageLoaderService;

@RestController
public class MessageLoaderController {
	@Autowired
	MessageLoaderService messageLoaderService;
	

	@RequestMapping(value = "/messages/{id}", method = RequestMethod.GET, produces = "application/json")
	public MessageQueue getMessages(@PathVariable Integer id) {
		// System.out.println("HERE!!!");
		

		
		//System.out.println("Messages: " + messageQueue.getMessages().size());

		/*
		 * User currentUser = ArtefactBuilder.getUsers().getUserWithUsername(username);
		 * for(Message message : ArtefactBuilder.getMessageQueue().getMessages()) {
		 * if(message.getMessageAuthor().getUsername().equals(username) ||
		 * currentUser.getFriendsAsStrings().contains(message.getMessageAuthor().
		 * getUsername())) { messageQueue.addMessage(message); } }
		 */

		return messageLoaderService.getMessages(id);
	}
}
