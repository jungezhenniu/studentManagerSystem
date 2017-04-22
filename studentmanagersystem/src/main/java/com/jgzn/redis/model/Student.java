package com.jgzn.redis.model;

import java.util.Date;


public class Student {
	private String id;
	private String name;
	private Date birthday;
	private String description;
	private int avgscore;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getAvgscore() {
		return avgscore;
	}
	
	public void setAvgscore(int avgscore) {
		this.avgscore = avgscore;
	}
	
}
