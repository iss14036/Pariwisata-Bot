package com.Pariwisata.models.line;

import java.util.List;

public class LineSingleTemplate {
	private String type;
	private String thumbnailImageUrl;
	private String title;
	private String text;
	private List<LineAction> actions;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getThumbnailImageUrl() {
		return thumbnailImageUrl;
	}
	public void setThumbnailImageUrl(String thumbnailImageUrl) {
		this.thumbnailImageUrl = thumbnailImageUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<LineAction> getActions() {
		return actions;
	}
	public void setActions(List<LineAction> actions) {
		this.actions = actions;
	}
	
	public LineSingleTemplate(String type, String thumbnailImageUrl, String title, String text,
			List<LineAction> actions) {
		super();
		this.type = type;
		this.thumbnailImageUrl = thumbnailImageUrl;
		this.title = title;
		this.text = text;
		this.actions = actions;
	}
	public LineSingleTemplate() {
		super();
	}
	@Override
	public String toString() {
		return "LineSingleTemplate [type=" + type + ", thumbnailImageUrl=" + thumbnailImageUrl + ", title=" + title
				+ ", text=" + text + ", actions=" + actions + "]";
	}
	
	
	
}
