package cz.ssinfotech.chat.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.ssinfotech.chat.domain.Message;
import cz.ssinfotech.chat.domain.MessageRepository;

@Component
public class MessageService {
	
	@Autowired
	MessageRepository messageRepository;
	
	public void addMessage(String text) {
		Message message = new Message(text);
		messageRepository.addMessage(message);
	}
	
	public List<String> getMessages(){
		return messageRepository.getMessages()
				.stream()
				.map(Message::getText)
				.collect(Collectors.toList());
	}
}
