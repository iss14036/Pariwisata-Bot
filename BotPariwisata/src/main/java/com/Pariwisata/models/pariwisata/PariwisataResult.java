package com.Pariwisata.models.pariwisata;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PariwisataResult {
	private String formatted_address;
	private String icon;
	private String id;
	private String name;
	private List<PariwisataPhoto> photos;
	public String getFormatted_address() {
		return formatted_address;
	}
	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<PariwisataPhoto> getPhotos() {
		return photos;
	}
	public void setPhotos(List<PariwisataPhoto> photos) {
		this.photos = photos;
	}
	public PariwisataResult(String formatted_address, String icon, String id, String name,
			List<PariwisataPhoto> photos) {
		super();
		this.formatted_address = formatted_address;
		this.icon = icon;
		this.id = id;
		this.name = name;
		this.photos = photos;
	}
	@Override
	public String toString() {
		return "PariwisataResult [formatted_address=" + formatted_address + ", icon=" + icon + ", id=" + id + ", name="
				+ name + ", photos=" + photos + "]";
	}
	public PariwisataResult() {
		super();
	}
	
	
}
