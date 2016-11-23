package com.example.jdbcdemo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.example.jdbcdemo.domain.Pet;
import com.example.jdbcdemo.domain.Pet;

public class PetManagerTest {
	
	
	PetManager petManager = new PetManager();
	
	private final static String NAME_1 = "Ron";
	private final static String Type_1 = "Dog";
	private final static String Name_2 = "Bob";
	private final static String Type_2 = "Cat";
	private final static long Id_1 =0 ;
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
	@Test
	public void checkingUpdating(){
		Pet pet = new Pet(Name_2, Type_2);
		
		List<Pet> pets = petManager.getAllPets();
		Pet petRetrieved = pets.get(0);
		
		assertEquals(1,petManager.updatePet(pet, petRetrieved.getId()));
		
		List<Pet> pets2 = petManager.getAllPets();
		Pet petRetrieved2 = pets2.get(0);
		
		assertEquals(Name_2, petRetrieved2.getName());
		assertEquals(Type_2, petRetrieved2.getType());
	} 
}
