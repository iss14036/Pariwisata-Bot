package com.Pariwisata.models.db;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="t_state")
public class State {
	@Id
    private String id_user;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "t_event_id")
	private Event event;
	private String platform;
	public String getId_user() {
		return id_user;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	public State(String id_user, Event event, String platform) {
		super();
		this.id_user = id_user;
		this.event = event;
		this.platform = platform;
	}
	public State() {
		super();
	}
	@Override
	public String toString() {
		return "State [id_user=" + id_user + ", event_code=" + event + "]";
	}
	
}
