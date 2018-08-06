package com.Pariwisata.models.db;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="t_event")
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer event_code;
	@Column(name="event_description")
	private String eventDescription;
	@OneToMany(mappedBy = "event")
	private Set<State> states;
	public Set<State> getStates() {
		return states;
	}
	public void setStates(Set<State> states) {
		this.states = states;
	}
	
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	public Event() {
		super();
	}
	
	
}
