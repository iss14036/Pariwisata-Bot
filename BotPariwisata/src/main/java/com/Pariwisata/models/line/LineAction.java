package com.Pariwisata.models.line;

public class LineAction {
	private String type;
	private String label;
	private String data;
	private String uri;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public LineAction(String type, String label, String data, String uri) {
		super();
		this.type = type;
		this.label = label;
		this.data = data;
		this.uri = uri;
	}
	
	public LineAction() {
		super();
	}
	@Override
	public String toString() {
		return "LineAction [type=" + type + ", label=" + label + ", data=" + data + ", uri=" + uri + "]";
	}
	
}
