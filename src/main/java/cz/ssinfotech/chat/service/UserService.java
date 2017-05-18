package cz.ssinfotech.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.ssinfotech.chat.domain.User;
import cz.ssinfotech.chat.domain.UserRepository;

@Component
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public boolean isAlreadyLogged(String nick) {
		return userRepository.isLogged(nick);
	}

	public User createUser(String nick) {
		User user = new User(nick);
		userRepository.addUser(user);
		return user;
	}

}
