package com.Pariwisata.models.line;

public class LineSingleBody {
	private String type;
	private String altText;
	private LineSingleTemplate template;
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
	public LineSingleTemplate getTemplate() {
		return template;
	}
	public void setTemplate(LineSingleTemplate template) {
		this.template = template;
	}
	public LineSingleBody(String type, String altText, LineSingleTemplate template) {
		super();
		this.type = type;
		this.altText = altText;
		this.template = template;
	}
	public LineSingleBody() {
		super();
	}
	@Override
	public String toString() {
		return "LineSingleBody [type=" + type + ", altText=" + altText + ", template=" + template + "]";
	}
	
}
