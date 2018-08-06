package com.Pariwisata.models.kaskus;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Kaskus {
	private String from;
	private String fromPlain;
	private String to;
	private String stanza;
	private String body;
	private String timeStamp;
	private String messageId;
	private String client;
	@JsonProperty("secure-message")
	private KaskusSecureMessage secure_message;
	public Kaskus(String from, String fromPlain, String to, String stanza, String body, String timeStamp,
			String messageId, String client, KaskusSecureMessage secure_message) {
		super();
		this.from = from;
		this.fromPlain = fromPlain;
		this.to = to;
		this.stanza = stanza;
		this.body = body;
		this.timeStamp = timeStamp;
		this.messageId = messageId;
		this.client = client;
		this.secure_message = secure_message;
	}
	public Kaskus() {
		super();
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getFromPlain() {
		return fromPlain;
	}
	public void setFromPlain(String fromPlain) {
		this.fromPlain = fromPlain;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getStanza() {
		return stanza;
	}
	public void setStanza(String stanza) {
		this.stanza = stanza;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public KaskusSecureMessage getSecure_message() {
		return secure_message;
	}
	public void setSecure_message(KaskusSecureMessage secure_message) {
		this.secure_message = secure_message;
	}
	@Override
	public String toString() {
		return "Kaskus [from=" + from + ", fromPlain=" + fromPlain + ", to=" + to + ", stanza=" + stanza + ", body="
				+ body + ", timeStamp=" + timeStamp + ", messageId=" + messageId + ", client=" + client
				+ ", secure_message=" + secure_message + "]";
	}
	
	
}
