package com.internousdev.Warasibe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.Warasibe.util.DBConnector;

public class IndexDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public ArrayList<String> getCategory() throws SQLException{
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
