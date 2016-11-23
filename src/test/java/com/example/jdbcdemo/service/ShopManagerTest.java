package com.example.jdbcdemo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.example.jdbcdemo.domain.Pet;
import com.example.jdbcdemo.domain.Shop;

public class ShopManagerTest {
	
	
	ShopManager ShopManager = new ShopManager();
	
	private final static String NAME_1 = "Owczarek";
	private final static String Type_1 = "Dog";
	private final static int Price_1 = 50;
	private final static String NAME_2 = "Perski";
	private final static String Type_2 = "Cat";
	private final static int Price_2 = 60;
	private final static String NAME_3 = "Ron";
	@Test
	public void checkConnection(){
		assertNotNull(ShopManager.getConnection());
	}
	
	@Test
	public void checkAdding(){
		
		Shop Shop = new Shop(NAME_1, Type_1, Price_1);
		
		ShopManager.clearShops();
		assertEquals(1,ShopManager.addShop(Shop));
		
		List<Shop> Shops = ShopManager.getAllShops();
		Shop ShopRetrieved = Shops.get(0);
		
		assertEquals(NAME_1, ShopRetrieved.getName());
		assertEquals(Type_1, ShopRetrieved.getType());
		assertEquals(Price_1, ShopRetrieved.getPrice());
	}
	@Test
	public void checkingUpdating(){
		Shop shop = new Shop(NAME_2, Type_2, Price_2);
		
		List<Shop> shops = ShopManager.getAllShops();
		Shop shopRetrieved = shops.get(0);
		
		assertEquals(1,ShopManager.updateShop(shop, shopRetrieved.getId()));
		
		List<Shop> shops2 = ShopManager.getAllShops();
		Shop shopRetrieved2 = shops2.get(0);
		
		assertEquals(NAME_2, shopRetrieved2.getName());
		assertEquals(Type_2, shopRetrieved2.getType());
		assertEquals(Price_2, shopRetrieved2.getPrice());
	} 
	@Test
	public void checkingRelation(){
		Shop shop = new Shop(NAME_2, Type_2, Price_2);
		
		List<Shop> shops = ShopManager.getPets();
		Shop shopRetrieved = shops.get(0);
		
		assertEquals(NAME_1, shopRetrieved.getName());
		assertEquals(Type_1, shopRetrieved.getType());
		assertEquals(Price_1, shopRetrieved.getPrice());
		assertEquals(NAME_3, shopRetrieved.getPets());
	} 
}
