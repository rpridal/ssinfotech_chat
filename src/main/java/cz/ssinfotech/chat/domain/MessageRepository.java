package cz.ssinfotech.chat.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MessageRepository {
	private static final int MAX_ROW = 20;
	private final List<Message> repository = Collections.synchronizedList(new LinkedList<Message>());

	synchronized public void addMessage(Message message) {
		this.repository.add(message);
		if (repository.size() > MAX_ROW) {
			repository.remove(repository.get(0));
		}
	}

	public List<Message> getMessages() {
		List<Message> result = new ArrayList<Message>(this.repository);
		Collections.reverse(result);
		return result;
	}
}
