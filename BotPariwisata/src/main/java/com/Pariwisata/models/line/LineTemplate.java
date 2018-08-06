package com.Pariwisata.models.line;

import java.util.List;

public class LineTemplate {
	private String type;
	private List<LineColumn> columns;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<LineColumn> getColumns() {
		return columns;
	}
	public void setColumns(List<LineColumn> columns) {
		this.columns = columns;
	}
	public LineTemplate(String type, List<LineColumn> columns) {
		super();
		this.type = type;
		this.columns = columns;
	}
	public LineTemplate() {
		super();
	}
	@Override
	public String toString() {
		return "LineTemplate [type=" + type + ", columns=" + columns + "]";
	}
	
	
	
}
