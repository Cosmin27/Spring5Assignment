package com.cgm.assignment4spring.restcontrollers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cgm.assignment4spring.builders.ArtefactBuilder;
import com.cgm.assignment4spring.entities.Message;
import com.cgm.assignment4spring.entities.MessageQueue;
import com.cgm.assignment4spring.entities.User;

@RestController
public class MessageLoaderController {
	@RequestMapping(value="/messages/{username}", method=RequestMethod.GET, produces = "application/json")
	public MessageQueue getMessages(@PathVariable String username) {
		//System.out.println("HERE!!!");
		MessageQueue messageQueue = new MessageQueue();
		
		User currentUser = ArtefactBuilder.getUsers().getUserWithUsername(username);
		for(Message message : ArtefactBuilder.getMessageQueue().getMessages()) {
			if(message.getMessageAuthor().getUsername().equals(username) || currentUser.getFriendsAsStrings().contains(message.getMessageAuthor().getUsername())) {
				messageQueue.addMessage(message);
			}
		}
		
		return messageQueue;
	}
}
