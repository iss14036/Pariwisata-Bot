package com.Pariwisata.models.facebook;

public class FacebookSendButton {
	private FacebookRecipient recipient;
	private FacebookMessageButton message;
	public FacebookRecipient getRecipient() {
		return recipient;
	}
	public void setRecipient(FacebookRecipient recipient) {
		this.recipient = recipient;
	}
	public FacebookMessageButton getMessage() {
		return message;
	}
	public void setMessage(FacebookMessageButton message) {
		this.message = message;
	}
	public FacebookSendButton(FacebookRecipient recipient, FacebookMessageButton message) {
		super();
		this.recipient = recipient;
		this.message = message;
	}
	public FacebookSendButton() {
		super();
	}
	
}
