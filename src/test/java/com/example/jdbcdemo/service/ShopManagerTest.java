package com.example.jdbcdemo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.example.jdbcdemo.domain.Shop;

public class ShopManagerTest {
	
	
	ShopManager ShopManager = new ShopManager();
	
	private final static String NAME_1 = "Owczarek";
	private final static String Type_1 = "Pies";
	private final static int Price_1 = 50;
	@Test
	public void checkConnection(){
		assertNotNull(ShopManager.getConnection());
	}
	
	@Test
	public void checkAdding(){
		
		Shop Shop = new Shop(NAME_1,Type_1,Price_1);
		
		ShopManager.clearShops();
		assertEquals(1,ShopManager.addShop(Shop));
		
		List<Shop> Shops = ShopManager.getAllShops();
		Shop ShopRetrieved = Shops.get(0);
		
		assertEquals(NAME_1, ShopRetrieved.getName());
		assertEquals(Type_1, ShopRetrieved.getType());
		assertEquals(Price_1, ShopRetrieved.getPrice());
	}

}
