package com.Pariwisata.models.kaskus;

public class KaskusSecureMessage {
	private String secret;
	private String iv;
	private String namespace;
	private String elementName;
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getIv() {
		return iv;
	}
	public void setIv(String iv) {
		this.iv = iv;
	}
	public String getNamespace() {
		return namespace;
	}
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	public String getElementName() {
		return elementName;
	}
	public void setElementName(String elementName) {
		this.elementName = elementName;
	}
	@Override
	public String toString() {
		return "KaskusSecureMessage [secret=" + secret + ", iv=" + iv + ", namespace=" + namespace + ", elementName="
				+ elementName + "]";
	}
	public KaskusSecureMessage(String secret, String iv, String namespace, String elementName) {
		super();
		this.secret = secret;
		this.iv = iv;
		this.namespace = namespace;
		this.elementName = elementName;
	}
	public KaskusSecureMessage() {
		super();
	}
	
}
