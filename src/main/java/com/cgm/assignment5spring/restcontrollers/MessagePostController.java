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
import com.cgm.assignment5spring.services.MessageService;

@RestController
public class MessagePostController {
	@Autowired
	MessageService messageService;
	
	@RequestMapping(value="/postMessage", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public Message postMessage(@RequestBody Message message, HttpServletRequest request) {
		return messageService.postMessage(message, (Integer) request.getSession().getAttribute("userID"));
	}
}
