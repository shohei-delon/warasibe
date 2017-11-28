package com.internousdev.Warasibe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.Warasibe.dto.AccountDTO;
import com.internousdev.Warasibe.util.DBConnector;

public class LoginDAO implements AccountDAO{

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private AccountDTO accountDTO = new AccountDTO();

	@Override
	public AccountDTO getAccount(int id) throws SQLException {
		AccountDTO dto = new AccountDTO();

		String sql = ""
				+ "SELECT id, login_id, login_password, nickname, introduce "
				+ "FROM account "
				+ "WHERE id = ?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();

		while(resultSet.next()) {
			dto.setId(resultSet.getInt("id"));
			dto.setLoginUserId(resultSet.getString("login_id"));
			dto.setLoginPassword(resultSet.getString("login_password"));
			dto.setNickname(resultSet.getString("nickname"));
			dto.setIntroduce(resultSet.getString("introduce"));
		}

		return dto;
	}

	public void updateLoginAuth(int id, String newId, String newPassword) throws SQLException {
		String sql = ""
				+ "UPDATE Account "
				+ "SET login_id = ?, login_password = ? "
				+ "WHERE id = ?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, newId);
		statement.setString(2, newPassword);
		statement.setInt(3, id);

		statement.executeUpdate();
	}

	public void updateAccount(int id, String nickname, String introduce) throws SQLException {
		String sql = ""
				+ "UPDATE Account "
				+ "SET nickname = ?, introduce = ? "
				+ "WHERE id = ?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, nickname);
		statement.setString(2, introduce);
		statement.setInt(3, id);

		statement.executeUpdate();
	}

	public AccountDTO getLoginUserInfo(String loginUserId, String loginPassword){
		String sql = "SELECT * FROM account WHERE login_id = ? AND login_password = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, loginUserId);
			statement.setString(2, loginPassword);

			ResultSet resultSet = statement.executeQuery();

			if(resultSet.next()){
				accountDTO.setId(resultSet.getInt("id"));
				accountDTO.setLoginUserId(resultSet.getString("login_id"));
				accountDTO.setLoginPassword(resultSet.getString("login_password"));
				accountDTO.setMail(resultSet.getString("mail"));
				accountDTO.setNickname(resultSet.getString("nickname"));
				accountDTO.setEvaluation(resultSet.getFloat("evaluation"));

				if(!resultSet.getString("login_id").equals("")){
					accountDTO.setLogin(true);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountDTO;
	}
}
