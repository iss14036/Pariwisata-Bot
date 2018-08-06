package com.Pariwisata.models.kaskus;

import java.util.List;

public class KaskusBody {
	private List<KaskusInteractive> interactives;

	public List<KaskusInteractive> getInteractives() {
		return interactives;
	}



	public void setInteractives(List<KaskusInteractive> interactives) {
		this.interactives = interactives;
	}

	

	@Override
	public String toString() {
		return "KaskusBody [interactives=" + interactives + "]";
	}

	

	public KaskusBody(List<KaskusInteractive> interactives) {
		super();
		this.interactives = interactives;
	}



	public KaskusBody() {
		super();
	}
	
	
}
