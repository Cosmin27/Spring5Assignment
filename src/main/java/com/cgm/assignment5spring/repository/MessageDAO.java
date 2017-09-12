package com.cgm.assignment5spring.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.cgm.assignment5spring.domain.Message;
import com.cgm.assignment5spring.domain.User;

@Repository
public class MessageDAO extends AbstractDAO<Message>{
	protected MessageDAO() {
		super(Message.class);
	}
	
}
