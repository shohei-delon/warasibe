package com.internousdev.Warasibe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import com.internousdev.Warasibe.util.DBConnector;

public class CategoryDAO {

	private DBConnector connector = new DBConnector();
	private Connection connection = connector.getConnection();

	public Map<Integer, String> getCategoryMap() throws SQLException{
		Map<Integer, String> categoryMap = new TreeMap<Integer, String>();

		String sql = "SELECT * FROM category";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
			categoryMap.put(resultSet.getInt("id"), resultSet.getString("name"));
		}

		return categoryMap;
	}

	public ArrayList<String> getCategoryList() throws SQLException{
		ArrayList<String> categoryList = new ArrayList<>();

		String sql = "SELECT * FROM category";

		PreparedStatement statement = connection.prepareStatement(sql);

		ResultSet resultSet = statement.executeQuery();

		while(resultSet.next()){
			categoryList.add(resultSet.getString("name"));
		}

		connection.close();

		return categoryList;
	}

}
