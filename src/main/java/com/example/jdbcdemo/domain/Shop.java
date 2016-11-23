package com.example.jdbcdemo.domain;

public class Shop {
private long id;
	
	private String Name;
	private String Type;
	
	public Shop() {
	}
	
	public Shop(String Name) {
		super();
		this.Name = Name;
	}
	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
