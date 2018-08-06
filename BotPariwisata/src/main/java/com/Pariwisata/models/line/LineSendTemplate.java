package com.Pariwisata.models.line;

import java.util.List;

public class LineSendTemplate {
	private String to;
	private List<LineSingleBody> messages;
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public List<LineSingleBody> getMessages() {
		return messages;
	}
	public void setMessages(List<LineSingleBody> messages) {
		this.messages = messages;
	}
	public LineSendTemplate(String to, List<LineSingleBody> messages) {
		super();
		this.to = to;
		this.messages = messages;
	}
	public LineSendTemplate() {
		super();
	}
	@Override
	public String toString() {
		return "LineSendTemplate [to=" + to + ", messages=" + messages + "]";
	}
	
}
