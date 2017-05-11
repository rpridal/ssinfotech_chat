package cz.ssinfotech.chat.domain;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
	private final String text;
	private final Instant createdAt = Instant.now();

	public Message(String text) {
		this.text = text;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.createdAt == null) ? 0 : this.createdAt.hashCode());
		result = prime * result + ((this.text == null) ? 0 : this.text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final Message other = (Message) obj;
		if (this.createdAt == null) {
			if (other.createdAt != null) {
				return false;
			}
		} else if (!this.createdAt.equals(other.createdAt)) {
			return false;
		}
		if (this.text == null) {
			if (other.text != null) {
				return false;
			}
		} else if (!this.text.equals(other.text)) {
			return false;
		}
		return true;
	}


	public String getCreatedAt() {
		final Date created = Date.from(this.createdAt);
		final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		final String formattedDate = formatter.format(created);
		return formattedDate;
	}

}
