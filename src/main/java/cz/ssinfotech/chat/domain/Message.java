package cz.ssinfotech.chat.domain;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Message {
	private final String text;
	private final Instant createdAt = Instant.now();
	private final User user;

	public Message(String text, User user) {
		this.text = text;
		this.user = user;
	}
	
	public String getText() {
		return text;
	}
	
	public User getUser() {
		return user;
	}

	public String getCreatedAt() {
		final Date created = Date.from(this.createdAt);
		final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		final String formattedDate = formatter.format(created);
		return formattedDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
}
