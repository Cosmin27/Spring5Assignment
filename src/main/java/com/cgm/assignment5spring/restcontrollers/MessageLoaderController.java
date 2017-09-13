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
import com.cgm.assignment5spring.domain.User;
import com.cgm.assignment5spring.dto.MessageQueue;
import com.cgm.assignment5spring.repository.MessageDAO;
import com.cgm.assignment5spring.repository.UserDAO;
import com.cgm.assignment5spring.services.MessageService;

@RestController
public class MessageLoaderController {
	@Autowired
	MessageService messageLoaderService;
	

	@RequestMapping(value = "/messages/{id}", method = RequestMethod.GET, produces = "application/json")
	public MessageQueue getMessages(@PathVariable Integer id) {
		return messageLoaderService.getMessages(id);
	}
}
