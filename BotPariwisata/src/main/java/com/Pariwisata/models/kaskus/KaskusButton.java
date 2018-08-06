package com.Pariwisata.models.kaskus;

public class KaskusButton {
	private String reply;
	private String text;
	private String show;
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getShow() {
		return show;
	}
	public void setShow(String show) {
		this.show = show;
	}
	@Override
	public String toString() {
		return "KaskusButton [reply=" + reply + ", text=" + text + ", show=" + show + "]";
	}
	public KaskusButton(String reply, String text, String show) {
		super();
		this.reply = reply;
		this.text = text;
		this.show = show;
	}
	public KaskusButton() {
		super();
	}
	
	
}
