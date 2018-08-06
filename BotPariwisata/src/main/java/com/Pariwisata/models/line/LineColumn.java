package com.Pariwisata.models.line;

import java.util.List;

public class LineColumn {
	private String thumbnailImageUrl;
	private String title;
	private String text;
	private List<LineAction> actions;
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
	public LineColumn(String thumbnailImageUrl, String title, String text, List<LineAction> actions) {
		super();
		this.thumbnailImageUrl = thumbnailImageUrl;
		this.title = title;
		this.text = text;
		this.actions = actions;
	}
	public LineColumn() {
		super();
	}
	@Override
	public String toString() {
		return "LineColumn [thumbnailImageUrl=" + thumbnailImageUrl + ", title=" + title + ", text=" + text
				+ ", actions=" + actions + "]";
	}
	
}
