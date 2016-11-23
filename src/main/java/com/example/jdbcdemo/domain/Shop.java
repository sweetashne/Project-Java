package com.example.jdbcdemo.domain;

import java.util.ArrayList;
import java.util.List;

public class Shop {
private long id;
	
	private String Name;
	private String Type;
	private int Price;
	private String pets;
	private List<Food> foods;
	public Shop() {
	}
	
	public Shop(String Name,String Type,int Price) {
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

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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


	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

	public void setPrice(int Price) {
		this.Price = Price;
	}

	public List<Food> getFoods(){
		return foods;
	}

	public String getPets() {
		return pets;
	}

	public void setPets(String pets) {
		this.pets = pets;
	}
	
}
