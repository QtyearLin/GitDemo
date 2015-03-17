package com.example.testviewpager;

import java.io.Serializable;

import org.apache.http.entity.SerializableEntity;

public class TestBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4964183022472111230L;
	private int type;
	private int url;
	private String title;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getUrl() {
		return url;
	}
	public void setUrl(int url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public TestBean(int type, int url, String title) {
		super();
		this.type = type;
		this.url = url;
		this.title = title;
	}
	
	

}
