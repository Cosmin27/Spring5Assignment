package com.cgm.assignment5spring.repository;

import org.springframework.stereotype.Repository;

import com.cgm.assignment5spring.domain.Message;

@Repository
public class MessageDAO extends AbstractDAO<Message>{
	protected MessageDAO() {
		super(Message.class);
	}
}
