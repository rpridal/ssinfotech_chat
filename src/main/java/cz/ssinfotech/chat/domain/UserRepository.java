package cz.ssinfotech.chat.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class UserRepository {
	private final List<User> repository = Collections.synchronizedList(new LinkedList<User>());

	public void addUser(User User) {
		this.repository.add(User);
	}

	public List<User> getUsers(){
		return Collections.unmodifiableList(this.repository);
	}

	public boolean isLogged(String nick) {
		Optional<User> any = repository.
				stream().
				filter(u->u.getNick().equals(nick)).
				findAny();
		return any.isPresent();
	}
}
