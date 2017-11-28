package com.internousdev.Warasibe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.Warasibe.dto.AccountDTO;
import com.internousdev.Warasibe.dto.OtherAccountDTO;
import com.internousdev.Warasibe.util.DBConnector;

public class OtherAccountDAO implements AccountDAO{

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	@Override
	public AccountDTO getAccount(int id) throws SQLException {
		AccountDTO dto = new AccountDTO();

		String sql = ""
				+ "SELECT id, nickname, introduce, evaluation, trade_count "
				+ "FROM account "
				+ "WHERE id = ?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();

		while(resultSet.next()) {
			dto.setId(resultSet.getInt("id"));
			dto.setNickname(resultSet.getString("nickname"));
			dto.setIntroduce(resultSet.getString("introduce"));
			dto.setEvaluation(resultSet.getFloat("evaluation"));
			dto.setTradeCount(resultSet.getInt("trade_count"));
		}

		return dto;
	}

	public ArrayList<OtherAccountDTO> getAccountTradeCount() throws SQLException {
		ArrayList<OtherAccountDTO> list = new ArrayList<>();

		String sql = ""
				+ "SELECT id, nickname, introduce, evaluation, trade_count "
				+ "FROM account "
				+ "ORDER BY trade_count DESC "
				+ "LIMIT 5";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();

		while(resultSet.next()) {
			OtherAccountDTO dto = new OtherAccountDTO();
			dto.setId(resultSet.getInt("id"));
			dto.setNickname(resultSet.getString("nickname"));
			dto.setIntroduce(resultSet.getString("introduce"));
			dto.setEvaluation(resultSet.getFloat("evaluation"));
			dto.setTrade_count(resultSet.getInt("trade_count"));
			list.add(dto);
		}

		return list;
	}

	public ArrayList<OtherAccountDTO> getAccountEvaluation() throws SQLException {
		ArrayList<OtherAccountDTO> list = new ArrayList<>();

		String sql = ""
				+ "SELECT id, nickname, introduce, evaluation, trade_count "
				+ "FROM account "
				+ "ORDER BY evaluation DESC "
				+ "LIMIT 5";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();

		while(resultSet.next()) {
			OtherAccountDTO dto = new OtherAccountDTO();
			dto.setId(resultSet.getInt("id"));
			dto.setNickname(resultSet.getString("nickname"));
			dto.setIntroduce(resultSet.getString("introduce"));
			dto.setEvaluation(resultSet.getFloat("evaluation"));
			dto.setTrade_count(resultSet.getInt("trade_count"));
			list.add(dto);
		}

		return list;
	}

	public void setEvaluation(int rate, int yourId) throws SQLException {
		if(rate!=0) {
			String sql = ""
					+ "UPDATE account "
					+ "SET evaluation = (evaluation + ?)/2 "
					+ "WHERE id = ? ";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, rate);
			statement.setInt(2, yourId);

			statement.executeUpdate();
		}
	}

}
