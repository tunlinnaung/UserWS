package com.me.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response {

	private int id;
	private String message;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
}
