package com.Pariwisata.models.facebook;

public class FacebookMessageSend {
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public FacebookMessageSend(String text) {
		super();
		this.text = text;
	}

	@Override
	public String toString() {
		return "FacebookMessageSend [text=" + text + "]";
	}
	
}
