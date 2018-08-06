package com.Pariwisata.models.facebook;

public class FacebookButton {
	private String type;
	private String title;
	private String url;
	private String payload;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
	public FacebookButton(String type, String title, String url, String payload) {
		super();
		this.type = type;
		this.title = title;
		this.url = url;
		this.payload = payload;
	}
	public FacebookButton() {
		super();
	}
	@Override
	public String toString() {
		return "FacebookButton [type=" + type + ", title=" + title + ", url=" + url + ", payload=" + payload + "]";
	}
	
	
}
