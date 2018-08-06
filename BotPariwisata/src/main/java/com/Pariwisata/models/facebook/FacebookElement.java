package com.Pariwisata.models.facebook;

import java.util.List;

public class FacebookElement {
	private String title;
	private String image_url;
	private String subtitle;
	private FacebookDefaultAction default_action;
	private List<FacebookButton> buttons;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public FacebookDefaultAction getDefault_action() {
		return default_action;
	}
	public void setDefault_action(FacebookDefaultAction default_action) {
		this.default_action = default_action;
	}
	public List<FacebookButton> getButtons() {
		return buttons;
	}
	public void setButtons(List<FacebookButton> buttons) {
		this.buttons = buttons;
	}
	public FacebookElement(String title, String image_url, String subtitle, FacebookDefaultAction default_action,
			List<FacebookButton> buttons) {
		super();
		this.title = title;
		this.image_url = image_url;
		this.subtitle = subtitle;
		this.default_action = default_action;
		this.buttons = buttons;
	}
	public FacebookElement() {
		super();
	}
	@Override
	public String toString() {
		return "FacebookElement [title=" + title + ", image_url=" + image_url + ", subtitle=" + subtitle
				+ ", default_action=" + default_action + ", buttons=" + buttons + "]";
	}
	
}
