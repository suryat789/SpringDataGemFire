package com.dev.surya.springdata.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dev.surya.springdata.repo.MessageRepository;

@Component
public class GemFireBean {
	@Autowired
	MessageRepository messageRepository;

	public MessageRepository getMessageRepository() {
		return messageRepository;
	}

	public void setMessageRepository(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}
}
