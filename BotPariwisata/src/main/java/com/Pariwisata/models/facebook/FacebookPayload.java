package com.Pariwisata.models.facebook;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class FacebookPayload {
	private String template_type;
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	private String text;
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	private List<FacebookButton> buttons;
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	private List<FacebookElement> elements;
	
	public String getTemplate_type() {
		return template_type;
	}
	public void setTemplate_type(String template_type) {
		this.template_type = template_type;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<FacebookButton> getButtons() {
		return buttons;
	}
	public void setButtons(List<FacebookButton> buttons) {
		this.buttons = buttons;
	}
	
	public List<FacebookElement> getElements() {
		return elements;
	}
	public void setElements(List<FacebookElement> elements) {
		this.elements = elements;
	}
	public FacebookPayload(String template_type, String text, List<FacebookButton> buttons) {
		super();
		this.template_type = template_type;
		this.text = text;
		this.buttons = buttons;
	}
	public FacebookPayload(String template_type, List<FacebookElement> elements) {
		super();
		this.template_type = template_type;
		this.elements = elements;
	}
	public FacebookPayload() {
		super();
	}
	
}
