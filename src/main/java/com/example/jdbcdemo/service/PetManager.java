package com.example.jdbcdemo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.jdbcdemo.domain.Pet;

public class PetManager {

	private Connection connection;

	private String url = "jdbc:hsqldb:hsql://localhost/workdb";

	private String createTablePet = "CREATE TABLE Pet(id bigint GENERATED BY DEFAULT AS IDENTITY, Name varchar(20), Type varchar(20), Price integer)";

	private PreparedStatement addPetStmt;
	private PreparedStatement deleteAllPetsStmt;
	private PreparedStatement getAllPetsStmt;

	private Statement statement;

	public PetManager() {
		try {
			connection = DriverManager.getConnection(url);
			statement = connection.createStatement();

			ResultSet rs = connection.getMetaData().getTables(null, null, null,
					null);
			boolean tableExists = false;
			while (rs.next()) {
				if ("Pet".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					tableExists = true;
					break;
				}
			}

			if (!tableExists)
				statement.executeUpdate(createTablePet);

			addPetStmt = connection
					.prepareStatement("INSERT INTO Pet (Name, Type, Price) VALUES (?, ?, ?)");
			deleteAllPetsStmt = connection
					.prepareStatement("DELETE FROM Pet");
			getAllPetsStmt = connection
					.prepareStatement("SELECT id, Name, Type, Price FROM Pet");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	Connection getConnection() {
		return connection;
	}

	void clearPets() {
		try {
			deleteAllPetsStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int addPet(Pet pet) {
		int count = 0;
		try {
			addPetStmt.setString(1, pet.getName());
			addPetStmt.setString(2, pet.getType());
			addPetStmt.setInt(3, pet.getPrice());

			count = addPetStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<Pet> getAllPets() {
		List<Pet> pets = new ArrayList<Pet>();

		try {
			ResultSet rs = getAllPetsStmt.executeQuery();

			while (rs.next()) {
				Pet p = new Pet();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("Name"));
				p.setType(rs.getString("Type"));
				p.setPrice(rs.getInt("Price"));
				pets.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pets;
	}

}
