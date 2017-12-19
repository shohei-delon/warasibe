package com.internousdev.Warasibe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.Warasibe.util.DBConnector;
import com.internousdev.Warasibe.util.DateUtil;

public class TradeDAO {

	DBConnector connector = new DBConnector();
	Connection connection = connector.getConnection();

	public void AgreeTrade(int wishInfoId) throws SQLException {

		String sql = ""
				+ "INSERT INTO trade_status("
				+ "wish_info_id, trade_start_date"
				+ ") VALUES("
				+ "?, ?)";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, wishInfoId);
		statement.setString(2, new DateUtil().getDate());
		statement.executeUpdate();

		changeAgreement(wishInfoId);

	}

	public void completeTrade(int wishInfoId) throws SQLException {
		//商品情報を削除してからほしいものリストを削除
		deleteCommodity(wishInfoId);
		deleteWishList(wishInfoId);
	}

	private void changeAgreement(int wishInfoId) throws SQLException {
		String sql = ""
				+ "UPDATE wish_info "
				+ "SET Agreement = true "
				+ "WHERE id = ? ";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, wishInfoId);
		statement.executeUpdate();
	}

	private void deleteWishList(int wishInfoId) throws SQLException {
		String sql = ""
				+ "DELETE FROM wish_info "
				+ "WHERE id = ? ";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, wishInfoId);

		statement.executeUpdate();
	}

	private void deleteCommodity(int wishInfoId) throws SQLException {
		String sql = ""
				+ "DELETE com "
				+ "FROM commodity com "
				+ "INNER JOIN wish_info wi "
				+ "ON (wi.have_commodity_id = com.id "
				+ "OR wi.applied_commodity_id = com.id) "
				+ "AND wi.id = ? ";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, wishInfoId);
		statement.executeUpdate();
	}



	public int getStatus(int wishInfoId) throws SQLException{
		String sql = ""
				+ "SELECT progress+0 "
				+ "FROM trade_status "
				+ "WHERE wish_info_id = ? ";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, wishInfoId);

		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()) {
			return resultSet.getInt("progress+0");
		}
		return 0;
	}

	public void setStatus(int wishInfoId) throws SQLException {
		String sql = ""
			+ "UPDATE trade_status "
			+ "SET progress = progress + 1 "
			+ "WHERE wish_info_id = ? ";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, wishInfoId);

		statement.executeUpdate();
	}

	public void addArrived(int wishInfoId, int myUserId) throws SQLException {
		String sql = ""
				+ "INSERT INTO arrived(trade_status_id, arrived_user_id) "
				+ "SELECT trade_status.id, ? "
				+ "FROM trade_status "
				+ "WHERE trade_status.wish_info_id = ? ";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, myUserId);
		statement.setInt(2, wishInfoId);

		statement.executeUpdate();
	}

	public boolean isArrived(int wishInfoId, int myUserId) throws SQLException {
		String sql = ""
				+ "SELECT * "
				+ "FROM arrived "
				+ "INNER JOIN trade_status "
				+ "ON arrived.trade_status_id = trade_status.id "
				+ "AND trade_status.wish_info_id = ? "
				+ "WHERE arrived.arrived_user_id = ? ";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, wishInfoId);
		statement.setInt(2, myUserId);

		ResultSet resultSet = statement.executeQuery();

		return resultSet.next();
	}

	public void addReviewed(int wishInfoId, int myUserId) throws SQLException {
		String sql = ""
				+ "INSERT INTO reviewed("
				+ "trade_status_id, reviewed_user_id) "
				+ "SELECT trade_status.id, ? "
				+ "FROM trade_status "
				+ "JOIN wish_info "
				+ "ON trade_status.wish_info_id = wish_info.id "
				+ "AND wish_info.id = ? ";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, myUserId);
		statement.setInt(2, wishInfoId);

		statement.executeUpdate();
	}


	public boolean isReviewed(int wishInfoId, int myUserId) throws SQLException {
		String sql = ""
				+ "SELECT * "
				+ "FROM reviewed "
				+ "INNER JOIN trade_status "
				+ "ON reviewed.trade_status_id = trade_status.id "
				+ "AND trade_status.wish_info_id = ? "
				+ "WHERE reviewed.reviewed_user_id = ? ";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, wishInfoId);
		statement.setInt(2, myUserId);

		ResultSet resultSet = statement.executeQuery();

		return resultSet.next();
	}

}
