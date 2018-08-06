package com.Pariwisata.models.line;

import java.util.List;

public class LineReplyTemplate {
	private String to;
	private List<LineBody> messages;
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public List<LineBody> getMessages() {
		return messages;
	}
	public void setMessages(List<LineBody> messages) {
		this.messages = messages;
	}
	public LineReplyTemplate(String to, List<LineBody> messages) {
		super();
		this.to = to;
		this.messages = messages;
	}
	public LineReplyTemplate() {
		super();
	}
	@Override
	public String toString() {
		return "LineReplyTemplate [to=" + to + ", messages=" + messages + "]";
	}
	
	
	
}
