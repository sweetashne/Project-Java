package com.example.jdbcdemo.domain;

import java.util.List;

public class Pet {
	
	private long id;
	
	private String Pname;
	private String Type;
	public Pet() {
	}
	
	public Pet(String Pname, String Type) {
		super();
		this.Pname = Pname;
		this.Type = Type;
	}
	public String getPname() {
		return Pname;
	}

	public void setPname(String Pname) {
		this.Pname = Pname;
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
