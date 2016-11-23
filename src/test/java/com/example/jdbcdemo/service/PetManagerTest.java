package com.example.jdbcdemo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.example.jdbcdemo.domain.Pet;

public class PetManagerTest {
	
	
	PetManager petManager = new PetManager();
	
	private final static String NAME_1 = "Ron";
	private final static String Type_1 = "Dog";
	
	@Test
	public void checkConnection(){
		assertNotNull(petManager.getConnection());
	}
	
	@Test
	public void checkAdding(){
		
		Pet pet = new Pet(NAME_1, Type_1);
		
		petManager.clearPets();
		assertEquals(1,petManager.addPet(pet));
		
		List<Pet> pets = petManager.getAllPets();
		Pet petRetrieved = pets.get(0);
		
		assertEquals(NAME_1, petRetrieved.getName());
		assertEquals(Type_1, petRetrieved.getType());
		
	}

}
