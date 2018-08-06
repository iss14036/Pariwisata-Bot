package com.Pariwisata.models.line;

public class LineReplyMessage {
	private String type;
	private String text;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "LineReplyMessage [type=" + type + ", text=" + text + "]";
	}
	public LineReplyMessage(String type, String text) {
		super();
		this.type = type;
		this.text = text;
	}
	public LineReplyMessage() {
		super();
	}
	
}
