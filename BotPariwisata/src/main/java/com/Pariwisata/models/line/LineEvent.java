package com.Pariwisata.models.line;

public class LineEvent {
	private String replyToken;
	private String type;
	private long timestamp;
	private LineSource source;
	private LineMessage message;
	private LinePostBack postback;
	public String getReplyToken() {
		return replyToken;
	}
	public void setReplyToken(String replyToken) {
		this.replyToken = replyToken;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public LineSource getSource() {
		return source;
	}
	public void setSource(LineSource source) {
		this.source = source;
	}
	public LineMessage getMessage() {
		return message;
	}
	public void setMessage(LineMessage message) {
		this.message = message;
	}
	
	public LinePostBack getPostback() {
		return postback;
	}
	public void setPostback(LinePostBack postback) {
		this.postback = postback;
	}
	@Override
	public String toString() {
		return "LineEvent [replyToken=" + replyToken + ", type=" + type + ", timestamp=" + timestamp + ", source="
				+ source + ", message=" + message + ", postback=" + postback + "]";
	}
}
