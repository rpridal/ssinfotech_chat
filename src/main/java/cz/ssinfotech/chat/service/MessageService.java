/**
 * @author jegllpet
 */
package cz.ssinfotech.chat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.ssinfotech.chat.domain.Message;
import cz.ssinfotech.chat.domain.MessageRepository;

@Component
public class MessageService {

	@Autowired
	MessageRepository messageRepository;

	public void addMessage(String text) {
		final Message message = new Message(text);
		this.messageRepository.addMessage(message);
	}

	public List<Message> getMessages(){
		return this.messageRepository.getMessages();
	}
}
