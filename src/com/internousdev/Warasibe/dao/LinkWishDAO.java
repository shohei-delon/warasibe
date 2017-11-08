package com.internousdev.Warasibe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.internousdev.Warasibe.dto.CommodityDTO;
import com.internousdev.Warasibe.dto.OtherAccountDTO;
import com.internousdev.Warasibe.util.DBConnector;

public class LinkWishDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public HashMap<OtherAccountDTO, CommodityDTO[]> getEachWishMap(int userId) throws SQLException{
		HashMap<OtherAccountDTO, CommodityDTO[]> map = new HashMap<>();

		//TODO 気持ち悪い DB設計

		String sql =""
				+ "SELECT com1.*, com1_category.name, com2.*, com2_category.name, account.id, account.nickname "
				+ "FROM wish_info AS wi1 "
				+ "INNER JOIN commodity AS com1 "
				+ "ON wi1.commodity_id = com1.id "
				+ "AND wi1.user_id = ? "
				+ "INNER JOIN category AS com1_category "
				+ "ON com1.category_id = com1_category.id "
				+ "INNER JOIN wish_info AS wi2 "
				+ "ON com1.sell_user_id = wi2.user_id "
				+ "INNER JOIN commodity AS com2 "
				+ "ON com2.id = wi2.commodity_id "
				+ "AND com2.sell_user_id = ? "
				+ "INNER JOIN category AS com2_category "
				+ "ON com1.category_id = com2_category.id "
				+ "INNER JOIN account "
				+ "ON com2.sell_user_id = account.id";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, userId);
		statement.setInt(2, userId);

		ResultSet resultSet = statement.executeQuery();

		while(resultSet.next()) {
			OtherAccountDTO accountDTO = new OtherAccountDTO();
			accountDTO.setId(resultSet.getInt("account.id"));
			accountDTO.setNickname(resultSet.getString("account.nickname"));

			CommodityDTO com1DTO = new CommodityDTO();
			com1DTO.setId(resultSet.getInt("com1.id"));
			com1DTO.setPostId(resultSet.getInt("com1.sell_user_id"));
			com1DTO.setName(resultSet.getString("com1.name"));
			com1DTO.setDetail(resultSet.getString("com1.detail"));
			com1DTO.setCategory(resultSet.getString("com1_category.name"));
			com1DTO.setColor(resultSet.getString("com1.color"));
			com1DTO.setAge(resultSet.getInt("com1.age"));
			com1DTO.setHeight(resultSet.getFloat("com1.height"));
			com1DTO.setWidth(resultSet.getFloat("com1.width"));
			com1DTO.setDepth(resultSet.getFloat("com1.depth"));
			com1DTO.setSize_unit(resultSet.getString("com1.size_unit"));
			com1DTO.setPostedDate(resultSet.getDate("com1.postdate"));

			CommodityDTO com2DTO = new CommodityDTO();
			com2DTO.setId(resultSet.getInt("com2.id"));
			com2DTO.setPostId(resultSet.getInt("com2.sell_user_id"));
			com2DTO.setName(resultSet.getString("com2.name"));
			com2DTO.setDetail(resultSet.getString("com2.detail"));
			com2DTO.setCategory(resultSet.getString("com2_category.name"));
			com2DTO.setColor(resultSet.getString("com2.color"));
			com2DTO.setAge(resultSet.getInt("com2.age"));
			com2DTO.setHeight(resultSet.getFloat("com2.height"));
			com2DTO.setWidth(resultSet.getFloat("com2.width"));
			com2DTO.setDepth(resultSet.getFloat("com2.depth"));
			com2DTO.setSize_unit(resultSet.getString("com2.size_unit"));
			com2DTO.setPostedDate(resultSet.getDate("com2.postdate"));

			CommodityDTO[] commodityMap = {com1DTO, com2DTO};

			map.put(accountDTO, commodityMap);
		}

		return map;
	}

}
