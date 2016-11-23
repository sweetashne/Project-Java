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
	private final static String Name_2 = "Unhealthy Food";
	private final static String Type_2 = "Cat food";
	private final static long Id_1 = 1;
	@Test
	public void checkConnection(){
		assertNotNull(FoodManager.getConnection());
	}
	
	@Test
	public void checkAdding(){
		
		Food food = new Food(NAME_1,Type_1);
		
		FoodManager.clearFoods();
		assertEquals(1,FoodManager.addFood(food));
		
		List<Food> foods = FoodManager.getAllFoods();
		Food FoodRetrieved = foods.get(0);
		
		assertEquals(NAME_1, FoodRetrieved.getName());
		assertEquals(Type_1, FoodRetrieved.getType());
		
		
	}
	@Test
	public void checkingUpdating(){
		Food food = new Food(Name_2, Type_2);
		
		assertEquals(1,FoodManager.updateFood(food, Id_1));
		
		List<Food> Foods = FoodManager.getAllFoods();
		Food FoodRetrieved = Foods.get(0);
		
		assertEquals(Name_2, FoodRetrieved.getName());
		assertEquals(Type_2, FoodRetrieved.getType());
	} 
}
