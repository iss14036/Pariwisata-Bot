package com.Pariwisata.models.kaskus;

import java.util.List;

public class KaskusSend {
	private long id;
	private List<KaskusSendList> sendList;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<KaskusSendList> getSendList() {
		return sendList;
	}
	public void setSendList(List<KaskusSendList> sendList) {
		this.sendList = sendList;
	}
	@Override
	public String toString() {
		return "KaskusSend [id=" + id + ", sendList=" + sendList + "]";
	}
	public KaskusSend(long id, List<KaskusSendList> sendList) {
		super();
		this.id = id;
		this.sendList = sendList;
	}
	public KaskusSend() {
		super();
	}
	
}
