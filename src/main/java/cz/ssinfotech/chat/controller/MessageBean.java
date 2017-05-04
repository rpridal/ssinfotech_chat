package cz.ssinfotech.chat.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cz.ssinfotech.chat.service.MessageService;

@ManagedBean
@RequestScoped
@Component
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
