package com.Pariwisata.models.pariwisata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PariwisataPhoto {
	private String photo_reference;

	public String getPhoto_reference() {
		return photo_reference;
	}

	public void setPhoto_reference(String photo_reference) {
		this.photo_reference = photo_reference;
	}

	@Override
	public String toString() {
		return "PariwisataPhoto [photo_reference=" + photo_reference + "]";
	}

	public PariwisataPhoto(String photo_reference) {
		super();
		this.photo_reference = photo_reference;
	}

	public PariwisataPhoto() {
		super();
	}
	
}
