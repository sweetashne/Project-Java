package com.example.jdbcdemo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.example.jdbcdemo.domain.Food;

public class FoodManagerTest {
	FoodManager FoodManager = new FoodManager();
	
	private final static String NAME_1 = "Healthy Food";
	private final static String Type_1 = "Dog food";
	private final static int Price_1 = 20;
	
	@Test
	public void checkConnection(){
		assertNotNull(FoodManager.getConnection());
	}
	
	@Test
	public void checkAdding(){
		
		Food Food = new Food(NAME_1, Type_1, Price_1);
		
		FoodManager.clearFoods();
		assertEquals(1,FoodManager.addFood(Food));
		
		List<Food> Foods = FoodManager.getAllFoods();
		Food FoodRetrieved = Foods.get(0);
		
		assertEquals(NAME_1, FoodRetrieved.getName());
		assertEquals(Type_1, FoodRetrieved.getType());
		assertEquals(Price_1, FoodRetrieved.getPrice());
		
	}

}
