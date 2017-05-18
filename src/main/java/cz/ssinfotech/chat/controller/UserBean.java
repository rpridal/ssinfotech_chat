package cz.ssinfotech.chat.controller;

import java.io.IOException;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cz.ssinfotech.chat.domain.User;
import cz.ssinfotech.chat.service.UserService;

@Component
@Scope("session")
public class UserBean {

	private User currentUser;
	
	private String nick;

	@Autowired
	private UserService userService;

	public User getCurrentUser() {
		return currentUser;
	}
	
	public void login() throws IOException{
		if(userService.isAlreadyLogged(nick)) {
			//TODO: implement showing error
		} else {
			currentUser = userService.createUser(nick);
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
		}
	}
	
	public void isLogged() throws IOException {
		if(currentUser == null) {
			 FacesContext.getCurrentInstance().getExternalContext().redirect("login.jsf"); 
		}
	}
	
	public String getNick() {
		return nick;
	}
	
	public void setNick(String nick) {
		this.nick = nick;
	}

}
