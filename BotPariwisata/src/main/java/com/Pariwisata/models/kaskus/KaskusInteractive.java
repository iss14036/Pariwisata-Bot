package com.Pariwisata.models.kaskus;

import java.util.List;

public class KaskusInteractive {
	private List<KaskusButton> buttons;
	private String image;
	private String title;
	private String caption;
	public List<KaskusButton> getButtons() {
		return buttons;
	}
	public void setButtons(List<KaskusButton> buttons) {
		this.buttons = buttons;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	@Override
	public String toString() {
		return "KaskusInteractive [buttons=" + buttons + ", image=" + image + ", title=" + title + ", caption="
				+ caption + "]";
	}
	public KaskusInteractive(List<KaskusButton> buttons, String image, String title, String caption) {
		super();
		this.buttons = buttons;
		this.image = image;
		this.title = title;
		this.caption = caption;
	}
	public KaskusInteractive() {
		super();
	}
	
	
}
