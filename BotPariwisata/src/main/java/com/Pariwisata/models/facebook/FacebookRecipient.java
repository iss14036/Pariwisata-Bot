package com.Pariwisata.models.facebook;

public class FacebookRecipient {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "FacebookRecipient [id=" + id + "]";
	}

	public FacebookRecipient(String id) {
		super();
		this.id = id;
	}

	public FacebookRecipient() {
		super();
	}
	
}
