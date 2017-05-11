/**
 * @author jegllpet
 */
package cz.ssinfotech.chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cz.ssinfotech.chat.domain.Message;
import cz.ssinfotech.chat.service.MessageService;
import lombok.Getter;
import lombok.Setter;

@Component
@Scope("request")
@Getter
@Setter
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
}
