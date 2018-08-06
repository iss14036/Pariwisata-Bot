package com.Pariwisata.models.line;

public class LineBody {
	private String type;
	private String altText;
	private LineTemplate template;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAltText() {
		return altText;
	}
	public void setAltText(String altText) {
		this.altText = altText;
	}
	public LineTemplate getTemplate() {
		return template;
	}
	public void setTemplate(LineTemplate template) {
		this.template = template;
	}
	public LineBody(String type, String altText, LineTemplate template) {
		super();
		this.type = type;
		this.altText = altText;
		this.template = template;
	}
	@Override
	public String toString() {
		return "LineBody [type=" + type + ", altText=" + altText + ", template=" + template + "]";
	}
	
}
