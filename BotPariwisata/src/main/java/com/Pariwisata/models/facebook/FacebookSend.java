package com.Pariwisata.models.facebook;

public class FacebookSend {
	private FacebookRecipient recipient;
	private FacebookMessageSend message;
	public FacebookRecipient getRecipient() {
		return recipient;
	}
	public void setRecipient(FacebookRecipient recipient) {
		this.recipient = recipient;
	}
	public FacebookMessageSend getMessage() {
		return message;
	}
	public void setMessage(FacebookMessageSend message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "FacebookSend [recipient=" + recipient + ", message=" + message + "]";
	}
	public FacebookSend(FacebookRecipient recipient, FacebookMessageSend message) {
		super();
		this.recipient = recipient;
		this.message = message;
	}
	public FacebookSend() {
		super();
	}
	
}
