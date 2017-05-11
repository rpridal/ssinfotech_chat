package cz.ssinfotech.chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cz.ssinfotech.chat.domain.Message;
import cz.ssinfotech.chat.service.MessageService;

@Component
@Scope("request")
public class MessageBean {

	@Autowired
	MessageService messageService;

	private String text = "";

	public void addMessage() {
		this.messageService.addMessage(this.text);
		this.text = "";
	}

	public List<Message> getMessages() {
		return this.messageService.getMessages();
	}
	
	public MessageService getMessageService() {
		return messageService;
	}
	
	public String getText() {
		return text;
	}
	
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	
	public void setText(String text) {
		this.text = text;
	}
}
