package com.cgm.assignment5spring.restcontrollers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cgm.assignment5spring.domain.Message;
import com.cgm.assignment5spring.domain.User;

@RestController
public class MessagePostController {
	@RequestMapping(value="/postMessage", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public Message postMessage(@RequestBody Message message, HttpServletRequest request) {
		//System.out.println("TEST "+message.getMessageText());
		User user = (User) request.getSession().getAttribute("userAccount");
		message.setMessageAuthor(user);
		//ArtefactBuilder.getMessageQueue().addMessage(message);
		
		return message;
	}
}
