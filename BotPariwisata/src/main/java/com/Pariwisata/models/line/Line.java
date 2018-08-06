package com.Pariwisata.models.line;

import java.util.List;


public class Line {
	private List<LineEvent> events;

	public List<LineEvent> getEvents() {
		return events;
	}

	public void setEvents(List<LineEvent> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "Line [events=" + events + "]";
	}
}
