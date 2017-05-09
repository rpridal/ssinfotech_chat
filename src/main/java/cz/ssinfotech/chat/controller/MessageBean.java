package cz.ssinfotech.chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cz.ssinfotech.chat.service.MessageService;

@Component
@Scope("request")
public class MessageBean {

	@Autowired
	MessageService messageService;

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void addMessage() {
		addMessage(this.getText());
	}

	public void addMessage(String message) {
		messageService.addMessage(message);
	}

	public List<String> getMessages() {
		return messageService.getMessages();
	}
}
