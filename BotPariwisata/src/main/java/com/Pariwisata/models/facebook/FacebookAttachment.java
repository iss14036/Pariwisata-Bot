package com.Pariwisata.models.facebook;

public class FacebookAttachment {
	private String type;
	private FacebookPayload payload;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public FacebookPayload getPayload() {
		return payload;
	}
	public void setPayload(FacebookPayload payload) {
		this.payload = payload;
	}
	public FacebookAttachment(String type, FacebookPayload payload) {
		super();
		this.type = type;
		this.payload = payload;
	}
	public FacebookAttachment() {
		super();
	}
	
	
}
