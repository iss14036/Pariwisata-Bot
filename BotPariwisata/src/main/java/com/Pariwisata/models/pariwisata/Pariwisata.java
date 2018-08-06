package com.Pariwisata.models.pariwisata;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pariwisata {
	List<PariwisataResult> results;

	public List<PariwisataResult> getResults() {
		return results;
	}

	public void setResults(List<PariwisataResult> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "Pariwisata [results=" + results + "]";
	}

	public Pariwisata(List<PariwisataResult> results) {
		super();
		this.results = results;
	}

	public Pariwisata() {
		super();
	}
	
	
}
