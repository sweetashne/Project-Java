package com.example.jdbcdemo.domain;

public class Food {
	private long id;
	
	private String Name;
	private String Type;
	private int Price;
	
	public Food() {
	}
	
	public Food(String Name, String Type, int Price) {
		super();
		this.Name = Name;
		this.Type = Type;
		this.Price = Price;
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

	public int getPrice() {
		return Price;
	}

	public void setPrice(int Price) {
		this.Price = Price;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
