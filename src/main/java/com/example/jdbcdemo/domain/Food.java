package com.example.jdbcdemo.domain;

public class Food {
	private long id;
	
	private String Fname;
	private String Type;
	
	public Food() {
	}
	
	public Food(String Fname, String Type) {
		super();
		this.Fname = Fname;
		this.Type = Type;
	}
	public String getFname() {
		return Fname;
	}

	public void setFname(String Fname) {
		this.Fname = Fname;
	}

	public String getType() {
		return Type;
	}

	public void setType(String Type) {
		this.Type = Type;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
}
