package com.example.jdbcdemo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.jdbcdemo.domain.Food;

public class FoodManager {
	private Connection connection;

	private String url = "jdbc:hsqldb:hsql://localhost/workdb";

	private String createTableFood = "CREATE TABLE Food(id bigint GENERATED BY DEFAULT AS IDENTITY, Name varchar(20), Type varchar(20), Price integer)";

	private PreparedStatement addFoodStmt;
	private PreparedStatement deleteAllFoodsStmt;
	private PreparedStatement getAllFoodsStmt;

	private Statement statement;

	public FoodManager() {
		try {
			connection = DriverManager.getConnection(url);
			statement = connection.createStatement();

			ResultSet rs = connection.getMetaData().getTables(null, null, null,
					null);
			boolean tableExists = false;
			while (rs.next()) {
				if ("Food".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					tableExists = true;
					break;
				}
			}

			if (!tableExists)
				statement.executeUpdate(createTableFood);

			addFoodStmt = connection
					.prepareStatement("INSERT INTO Food (Name, Type, Price) VALUES (?, ?, ?)");
			deleteAllFoodsStmt = connection
					.prepareStatement("DELETE FROM Food");
			getAllFoodsStmt = connection
					.prepareStatement("SELECT id, Name, Type, Price FROM Food");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	Connection getConnection() {
		return connection;
	}

	void clearFoods() {
		try {
			deleteAllFoodsStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int addFood(Food Food) {
		int count = 0;
		try {
			addFoodStmt.setString(1, Food.getName());
			addFoodStmt.setString(2, Food.getType());
			addFoodStmt.setInt(3, Food.getPrice());

			count = addFoodStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<Food> getAllFoods() {
		List<Food> Foods = new ArrayList<Food>();

		try {
			ResultSet rs = getAllFoodsStmt.executeQuery();

			while (rs.next()) {
				Food p = new Food();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("Name"));
				p.setType(rs.getString("Type"));
				p.setPrice(rs.getInt("Price"));
				Foods.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Foods;
	}
}