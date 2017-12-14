package com.internousdev.Warasibe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.Warasibe.dto.CommodityDTO;
import com.internousdev.Warasibe.util.DBConnector;

public class BelongsDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public ArrayList<CommodityDTO> getBelongsItem(int userId) throws SQLException{
		ArrayList<CommodityDTO> list = new ArrayList<>();

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
			CommodityDTO dto = new CommodityDTO();
			dto.setId(resultSet.getInt("commodity.id"));
			dto.setPostId(resultSet.getInt("sell_user_id"));
			dto.setName(resultSet.getString("commodity.name"));
			dto.setDetail(resultSet.getString("detail"));
			dto.setCategory(resultSet.getString("category.name"));
			dto.setColor(resultSet.getString("color"));
			dto.setAge(resultSet.getInt("age"));
			dto.setHeight(resultSet.getFloat("height"));
			dto.setWidth(resultSet.getFloat("width"));
			dto.setDepth(resultSet.getFloat("depth"));
			dto.setSize_unit(resultSet.getString("size_unit"));
			dto.setPostedDate(resultSet.getDate("postdate"));
			list.add(dto);
		}

		return list;
	}

	public void addBelongsItem(CommodityDTO dto) throws SQLException{
		String sql = ""
				+ "INSERT INTO commodity("
				+ "name, detail, category_id, color, age, height, width, depth, "
				+ "size_unit, close_trade, postdate, sell_user_id) "
				+ "VALUES("
				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, dto.getName());
		statement.setString(2, dto.getDetail());
		statement.setInt(3, dto.getCategory_i());
		statement.setString(4, dto.getColor());
		statement.setFloat(5, dto.getAge());
		statement.setFloat(6, dto.getHeight());
		statement.setFloat(7, dto.getWidth());
		statement.setFloat(8, dto.getDepth());
		statement.setString(9, dto.getSize_unit());
		statement.setBoolean(10, dto.isClose_trade());
		statement.setDate(11, new java.sql.Date(dto.getPostedDate().getTime()));
		statement.setInt(12, dto.getPostId());

		statement.executeUpdate();
	}

	public void removeBelongsItem(int itemId) throws SQLException{
		String sql = ""
				+ "DELETE FROM commodity "
				+ "WHERE id = ?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, itemId);

		statement.executeUpdate();
	}

}
