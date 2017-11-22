package com.internousdev.Warasibe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import com.internousdev.Warasibe.dto.CommodityDTO;
import com.internousdev.Warasibe.util.DBConnector;

public class WishDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public LinkedHashMap<Integer, CommodityDTO[]> getWishMap(int userId) throws SQLException{
		LinkedHashMap<Integer, CommodityDTO[]> map = new LinkedHashMap<>();

		String sql = ""
				+ "SELECT my_com.*, my_category.name, your_com.*, your_category.name, wish_info.* "
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
				+ "WHERE wish_info.agreement = 0";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, userId);
		ResultSet resultSet = statement.executeQuery();

		while(resultSet.next()) {
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
			Integer wishInfoId = resultSet.getInt("wish_info.id");

			CommodityDTO[] dtoList = {myComDTO,yourComDTO};

			map.put(wishInfoId, dtoList);

		}
		return map;
	}

	public int getYourId(int wishInfoId, int myUserId) throws SQLException {
		String sql = ""
				+ "SELECT applied_user_id, have_user_id "
				+ "FROM wish_info "
				+ "WHERE id = ? ";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, wishInfoId);

		ResultSet resultSet = statement.executeQuery();

		while(resultSet.next()) {
			if(resultSet.getInt("applied_user_id") == myUserId) {
				return resultSet.getInt("have_user_id");
			}else if(resultSet.getInt("have_user_id") == myUserId) {
				return resultSet.getInt("applied_user_id");
			}
		}
		return 0;
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

	public void removeWishItem(int wishInfoId) throws SQLException{
		String sql = ""
				+ "DELETE FROM wish_info "
				+ "WHERE id = ? ";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, wishInfoId);

		statement.executeUpdate();
	}

	public LinkedHashMap<Integer[], CommodityDTO[]> getAppliedMap(int userId) throws SQLException{
		LinkedHashMap<Integer[], CommodityDTO[]> map = new LinkedHashMap<>();

		String sql = ""
				+ "SELECT my_com.*, my_category.name, your_com.*, your_category.name, wish_info.id, wish_info.agreement "
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
				+ "WHERE wish_info.agreement = 0";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, userId);
		ResultSet resultSet = statement.executeQuery();

		while(resultSet.next()) {
			int wishInfoId = resultSet.getInt("wish_info.id");

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
			Integer[] agree_infoId = {resultSet.getInt("wish_info.agreement"), wishInfoId};

			LinkedHashMap<Integer[], CommodityDTO[]> falseMap = new LinkedHashMap<>();

			if(agree_infoId[0] == 0) {
				falseMap.put(agree_infoId, dtoList);
			}else {
				map.put(agree_infoId, dtoList);
			}
			map.putAll(falseMap);
		}

		return map;
	}

	public LinkedHashMap<Integer, CommodityDTO> getAgreedMap(int userId) throws SQLException {
		LinkedHashMap<Integer, CommodityDTO> map = new LinkedHashMap<>();

		String sql = ""
				+ "SELECT com.*, wish_info.id, category.name "
				+ "FROM wish_info "
				+ "INNER JOIN trade_status "
				+ "ON wish_info.id = trade_status.wish_info_id "
				+ "AND trade_status.progress < 5 "
				+ "INNER JOIN commodity AS com "
				+ "ON (wish_info.have_commodity_id = com.id "
				+ "OR wish_info.applied_commodity_id = com.id) "
				+ "AND com.sell_user_id = ? "
				+ "INNER JOIN category "
				+ "ON com.category_id = category.id "
				+ "WHERE wish_info.agreement "
				+ "AND ( wish_info.applied_user_id = ? "
				+ "OR wish_info.have_user_id = ? ) ";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, userId);
		statement.setInt(2, userId);
		statement.setInt(3, userId);
		ResultSet resultSet = statement.executeQuery();

		while(resultSet.next()) {
			int wishInfoId = resultSet.getInt("wish_info.id");

			CommodityDTO dto = new CommodityDTO();
			dto.setId(resultSet.getInt("com.id"));
			dto.setPostId(resultSet.getInt("com.sell_user_id"));
			dto.setName(resultSet.getString("com.name"));
			dto.setDetail(resultSet.getString("com.detail"));
			dto.setCategory(resultSet.getString("category.name"));
			dto.setColor(resultSet.getString("com.color"));
			dto.setAge(resultSet.getInt("com.age"));
			dto.setHeight(resultSet.getFloat("com.height"));
			dto.setWidth(resultSet.getFloat("com.width"));
			dto.setDepth(resultSet.getFloat("com.depth"));
			dto.setSize_unit(resultSet.getString("com.size_unit"));
			dto.setPostedDate(resultSet.getDate("com.postdate"));

			map.put(wishInfoId, dto);
		}

		return map;
	}


}
