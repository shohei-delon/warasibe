package com.internousdev.Warasibe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.Warasibe.dto.CommodityDTO;
import com.internousdev.Warasibe.util.DBConnector;

public class SearchDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connector = dbConnector.getConnection();

	public ArrayList<CommodityDTO> searchItem(String text) throws SQLException{
		ArrayList<CommodityDTO> list = new ArrayList<>();

		String sql = ""
				+ "SELECT * "
				+ "FROM commodity "
				+ "INNER JOIN category "
				+ "ON commodity.category_id = category.id "
				+ "WHERE commodity.name "
				+ "LIKE ?";

		PreparedStatement statement = connector.prepareStatement(sql);
		statement.setString(1, "%"+text+"%");
		ResultSet resultSet = statement.executeQuery();

		while(resultSet.next()) {
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

	public ArrayList<CommodityDTO> searchItem(int category) throws SQLException{
		ArrayList<CommodityDTO> list = new ArrayList<>();

		String sql = ""
				+ "SELECT * "
				+ "FROM commodity "
				+ "INNER JOIN category "
				+ "ON commodity.category_id = category.id "
				+ "WHERE category_id = ?";

		PreparedStatement statement = connector.prepareStatement(sql);
		statement.setInt(1, category);
		ResultSet resultSet = statement.executeQuery();

		while(resultSet.next()) {
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

	public ArrayList<CommodityDTO> searchItem(String text, int category) throws SQLException{
		ArrayList<CommodityDTO> list = new ArrayList<>();

		String sql = ""
				+ "SELECT * "
				+ "FROM commodity "
				+ "INNER JOIN category "
				+ "ON commodity.category_id = category.id "
				+ "WHERE commodity.name "
				+ "LIKE '%?%' "
				+ "AND category_id = ?";

		PreparedStatement statement = connector.prepareStatement(sql);
		statement.setString(1, text);
		statement.setInt(2, category);

		ResultSet resultSet = statement.executeQuery();

		while(resultSet.next()) {
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

	public ArrayList<CommodityDTO> searchItem() throws SQLException{
		ArrayList<CommodityDTO> list = new ArrayList<>();

		String sql = ""
				+ "SELECT * "
				+ "FROM commodity "
				+ "INNER JOIN category "
				+ "ON commodity.category_id = category.id";

		PreparedStatement statement = connector.prepareStatement(sql);

		ResultSet resultSet = statement.executeQuery();

		while(resultSet.next()) {
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
}
