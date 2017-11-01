package com.internousdev.Warasibe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.Warasibe.dto.BelongsItemDTO;
import com.internousdev.Warasibe.util.DBConnector;

public class BelongsDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public ArrayList<BelongsItemDTO> getBelongsItem(int userId) throws SQLException{
		ArrayList<BelongsItemDTO> list = new ArrayList<>();

		String sql = ""
				+ "SELECT * "
				+ "FROM commodity "
				+ "INNER JOIN category "
				+ "ON commodity.category_id = category.id "
				+ "WHERE sell_user_id = ?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, userId);

		ResultSet resultSet = statement.executeQuery();

		while(resultSet.next()){
			BelongsItemDTO dto = new BelongsItemDTO();
			dto.setPostId(resultSet.getInt("sell_user_id"));
			dto.setName(resultSet.getString("commodity.name"));
			dto.setDetail(resultSet.getString("detail"));
			dto.setCategory(resultSet.getString("category.name"));
			dto.setPrice(resultSet.getInt("price"));
			dto.setColor(resultSet.getString("color"));
			dto.setAge(resultSet.getInt("age"));
			dto.setHeight(resultSet.getFloat("height"));
			dto.setWidth(resultSet.getFloat("width"));
			dto.setDepth(resultSet.getFloat("depth"));
			dto.setSize_unit(resultSet.getString("size_unit"));
			dto.setPostedDate(resultSet.getDate("postdate"));
		}

		return list;
	}

	public void addBelongsItem(BelongsItemDTO dto) throws SQLException{
		String sql = ""
				+ "INSERT INTO commodity("
				+ "name, detail, category_id, price, color, age, height, width, depth, "
				+ "size_unit, close_trade, postdate, sell_user_id) "
				+ "VALUES("
				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, dto.getName());
		statement.setString(2, dto.getDetail());
		statement.setInt(3, dto.getCategory_i());
		statement.setInt(4, dto.getPrice());
		statement.setString(5, dto.getColor());
		statement.setFloat(6, dto.getAge());
		statement.setFloat(7, dto.getHeight());
		statement.setFloat(8, dto.getWidth());
		statement.setFloat(9, dto.getDepth());
		statement.setString(10, dto.getSize_unit());
		statement.setBoolean(11, dto.isClose_trade());
		statement.setDate(12, new java.sql.Date(dto.getPostedDate().getTime()));
		statement.setInt(13, dto.getPostId());

		statement.executeUpdate();
	}

}
