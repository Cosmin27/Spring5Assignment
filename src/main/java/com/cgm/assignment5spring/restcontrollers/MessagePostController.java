package com.cgm.assignment5spring.restcontrollers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cgm.assignment5spring.domain.Message;
import com.cgm.assignment5spring.domain.User;
import com.cgm.assignment5spring.repository.MessageDAO;
import com.cgm.assignment5spring.repository.UserDAO;

@RestController
public class MessagePostController {
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	MessageDAO messageDAO;
	
	@RequestMapping(value="/postMessage", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public Message postMessage(@RequestBody Message message, HttpServletRequest request) {
		//System.out.println("TEST "+message.getMessageText());
		User user = userDAO.findById((Integer) request.getSession().getAttribute("userID"));
		message.setMessageAuthor(user);
		//ArtefactBuilder.getMessageQueue().addMessage(message);
		messageDAO.save(message);
		return message;
	}
}
