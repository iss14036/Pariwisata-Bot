package com.Pariwisata.models.facebook;

public class FacebookMessageButton {
	private FacebookAttachment attachment;

	public FacebookAttachment getAttachment() {
		return attachment;
	}

	public void setAttachment(FacebookAttachment attachment) {
		this.attachment = attachment;
	}

	public FacebookMessageButton(FacebookAttachment attachment) {
		super();
		this.attachment = attachment;
	}

	@Override
	public String toString() {
		return "FacebookMessageButton [attachment=" + attachment + "]";
	}
	
}
