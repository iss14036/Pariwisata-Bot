package com.Pariwisata.models.line;

import java.util.List;

public class LineReply {
	private String to;
	private List<LineReplyMessage> messages;
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public List<LineReplyMessage> getMessages() {
		return messages;
	}
	public void setMessages(List<LineReplyMessage> messages) {
		this.messages = messages;
	}
	public LineReply(String to, List<LineReplyMessage> messages) {
		super();
		this.to = to;
		this.messages = messages;
	}
	public LineReply() {
		super();
	}
	
}
