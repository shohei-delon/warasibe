package com.internousdev.Warasibe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.Warasibe.dto.AccountDTO;
import com.internousdev.Warasibe.util.DBConnector;

public class LoginDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private AccountDTO accountDTO = new AccountDTO();

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
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return accountDTO;
	}
}
