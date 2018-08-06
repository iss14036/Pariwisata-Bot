package com.Pariwisata.models.facebook;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Facebook {
	private String object;
	private List<FacebookEntry> entry;
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	
	public List<FacebookEntry> getEntry() {
		return entry;
	}
	public void setEntry(List<FacebookEntry> entry) {
		this.entry = entry;
	}
	
	@Override
	public String toString() {
		return "Facebook [object=" + object + ", entry=" + entry + "]";
	}
	
}
