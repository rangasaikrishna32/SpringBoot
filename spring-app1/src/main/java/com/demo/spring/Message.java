package com.demo.spring;

public class Message {
	private  String Header;
	private String body;
	
	public String getHeader() {
		return Header;
	}

	public void setHeader(String header) {
		Header = header;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Message(String header, String body) {
		Header = header;
		this.body = body;
	}
	
	

}
