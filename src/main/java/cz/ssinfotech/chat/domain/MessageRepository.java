package cz.ssinfotech.chat.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MessageRepository {
	private final List<Message> repository = Collections.synchronizedList(new LinkedList<Message>());

	public void addMessage(Message message) {
		this.repository.add(message);
	}

	public List<Message> getMessages(){
		return Collections.unmodifiableList(this.repository);
	}
}
