package com.example.jdbcdemo.domain;

public class Pet {
	
	private long id;
	
	private String Name;
	private String Type;
	
	public Pet() {
	}
	
	public Pet(String Name, String Type) {
		super();
		this.Name = Name;
		this.Type = Type;
	}
	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
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
