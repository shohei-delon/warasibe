package com.internousdev.Warasibe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.internousdev.Warasibe.dto.CommodityDTO;
import com.internousdev.Warasibe.dto.OtherAccountDTO;
import com.internousdev.Warasibe.util.DBConnector;

public class WishDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public HashMap<OtherAccountDTO, CommodityDTO[]> getWishMap(int userId) throws SQLException{
		HashMap<OtherAccountDTO, CommodityDTO[]> map = new HashMap<OtherAccountDTO, CommodityDTO[]>();

		String sql = ""
				+ "SELECT my_com.*, my_category.name, your_com.*, your_category.name, account.id, account.nickname "
				+ "FROM wish_info "
				+ "INNER JOIN commodity AS my_com "
				+ "ON wish_info.have_commodity_id = my_com.id "
				+ "AND wish_info.applied_user_id = ? "
				+ "INNER JOIN category AS my_category "
				+ "ON my_com.category_id = my_category.id "
				+ "INNER JOIN commodity AS your_com "
				+ "ON wish_info.applied_commodity_id = your_com.id "
				+ "INNER JOIN category AS your_category "
				+ "ON your_com.category_id = your_category.id "
				+ "INNER JOIN account "
				+ "ON wish_info.have_user_id = account.id";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, userId);
		ResultSet resultSet = statement.executeQuery();

		while(resultSet.next()) {
			OtherAccountDTO accountDTO = new OtherAccountDTO();
			accountDTO.setId(resultSet.getInt("account.id"));
			accountDTO.setNickname(resultSet.getString("account.nickname"));

			CommodityDTO myComDTO = new CommodityDTO();
			myComDTO.setId(resultSet.getInt("my_com.id"));
			myComDTO.setPostId(resultSet.getInt("sell_user_id"));
			myComDTO.setName(resultSet.getString("my_com.name"));
			myComDTO.setDetail(resultSet.getString("detail"));
			myComDTO.setCategory(resultSet.getString("my_category.name"));
			myComDTO.setColor(resultSet.getString("color"));
			myComDTO.setAge(resultSet.getInt("age"));
			myComDTO.setHeight(resultSet.getFloat("height"));
			myComDTO.setWidth(resultSet.getFloat("width"));
			myComDTO.setDepth(resultSet.getFloat("depth"));
			myComDTO.setSize_unit(resultSet.getString("size_unit"));
			myComDTO.setPostedDate(resultSet.getDate("postdate"));

			CommodityDTO yourComDTO = new CommodityDTO();
			yourComDTO.setId(resultSet.getInt("your_com.id"));
			yourComDTO.setPostId(resultSet.getInt("sell_user_id"));
			yourComDTO.setName(resultSet.getString("your_com.name"));
			yourComDTO.setDetail(resultSet.getString("detail"));
			yourComDTO.setCategory(resultSet.getString("your_category.name"));
			yourComDTO.setColor(resultSet.getString("color"));
			yourComDTO.setAge(resultSet.getInt("age"));
			yourComDTO.setHeight(resultSet.getFloat("height"));
			yourComDTO.setWidth(resultSet.getFloat("width"));
			yourComDTO.setDepth(resultSet.getFloat("depth"));
			yourComDTO.setSize_unit(resultSet.getString("size_unit"));
			yourComDTO.setPostedDate(resultSet.getDate("postdate"));

			CommodityDTO[] dtoList = {myComDTO,yourComDTO};

			map.put(accountDTO, dtoList);
		}

		return map;
	}

	public void addWishItem(int myUserId, int myCommodityId, int yourUserId, int yourCommodityId) throws SQLException{
		String sql = ""
				+ "INSERT INTO wish_info("
				+ "applied_user_id, have_commodity_id, have_user_id, applied_commodity_id"
				+ ") VALUES ("
				+ "?, ?, ?, ?"
				+ ")";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, myUserId);
		statement.setInt(2, myCommodityId);
		statement.setInt(3, yourUserId);
		statement.setInt(4, yourCommodityId);

		statement.executeUpdate();
	}

	public void removeWishItem(int myUserId, int myCommodityId, int yourUserId, int yourCommodityId) throws SQLException{
		String sql = ""
				+ "DELETE FROM wish_info "
				+ "WHERE applied_user_id = ? "
				+ "AND have_commodity_id = ? "
				+ "AND have_user_id =? "
				+ "AND applied_commodity_id = ?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, myUserId);
		statement.setInt(2, myCommodityId);
		statement.setInt(3, yourUserId);
		statement.setInt(4, yourCommodityId);

		statement.executeUpdate();
	}

	public HashMap<OtherAccountDTO, CommodityDTO[]> getAppliedMap(int userId) throws SQLException{
		HashMap<OtherAccountDTO, CommodityDTO[]> map = new HashMap<OtherAccountDTO, CommodityDTO[]>();

		String sql = ""
				+ "SELECT my_com.*, my_category.name, your_com.*, your_category.name, account.id, account.nickname "
				+ "FROM wish_info "
				+ "INNER JOIN commodity AS my_com "
				+ "ON wish_info.have_commodity_id = my_com.id "
				+ "AND wish_info.have_user_id = ? "
				+ "INNER JOIN category AS my_category "
				+ "ON my_com.category_id = my_category.id "
				+ "INNER JOIN commodity AS your_com "
				+ "ON wish_info.applied_commodity_id = your_com.id "
				+ "INNER JOIN category AS your_category "
				+ "ON your_com.category_id = your_category.id "
				+ "INNER JOIN account "
				+ "ON wish_info.have_user_id = account.id";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, userId);
		ResultSet resultSet = statement.executeQuery();

		while(resultSet.next()) {
			OtherAccountDTO accountDTO = new OtherAccountDTO();
			accountDTO.setId(resultSet.getInt("account.id"));
			accountDTO.setNickname(resultSet.getString("account.nickname"));

			CommodityDTO myComDTO = new CommodityDTO();
			myComDTO.setId(resultSet.getInt("my_com.id"));
			myComDTO.setPostId(resultSet.getInt("sell_user_id"));
			myComDTO.setName(resultSet.getString("my_com.name"));
			myComDTO.setDetail(resultSet.getString("detail"));
			myComDTO.setCategory(resultSet.getString("my_category.name"));
			myComDTO.setColor(resultSet.getString("color"));
			myComDTO.setAge(resultSet.getInt("age"));
			myComDTO.setHeight(resultSet.getFloat("height"));
			myComDTO.setWidth(resultSet.getFloat("width"));
			myComDTO.setDepth(resultSet.getFloat("depth"));
			myComDTO.setSize_unit(resultSet.getString("size_unit"));
			myComDTO.setPostedDate(resultSet.getDate("postdate"));

			CommodityDTO yourComDTO = new CommodityDTO();
			yourComDTO.setId(resultSet.getInt("your_com.id"));
			yourComDTO.setPostId(resultSet.getInt("sell_user_id"));
			yourComDTO.setName(resultSet.getString("your_com.name"));
			yourComDTO.setDetail(resultSet.getString("detail"));
			yourComDTO.setCategory(resultSet.getString("your_category.name"));
			yourComDTO.setColor(resultSet.getString("color"));
			yourComDTO.setAge(resultSet.getInt("age"));
			yourComDTO.setHeight(resultSet.getFloat("height"));
			yourComDTO.setWidth(resultSet.getFloat("width"));
			yourComDTO.setDepth(resultSet.getFloat("depth"));
			yourComDTO.setSize_unit(resultSet.getString("size_unit"));
			yourComDTO.setPostedDate(resultSet.getDate("postdate"));

			CommodityDTO[] dtoList = {myComDTO,yourComDTO};

			map.put(accountDTO, dtoList);
		}

		return map;
	}

}
