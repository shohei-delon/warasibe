package com.internousdev.Warasibe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.internousdev.Warasibe.dto.AccountDTO;
import com.internousdev.Warasibe.util.DBConnector;

public class SignupDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	private String sql = "INSERT INTO account(login_id, login_password, nickname, mail) VALUES (?,?,?,?)";

	public int userCreate(AccountDTO accountDTO) throws SQLException{
		int id = 0;
		PreparedStatement statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, accountDTO.getLoginUserId());
		statement.setString(2, accountDTO.getLoginPassword());
		statement.setString(3, accountDTO.getNickname());
		statement.setString(4, accountDTO.getMail());

		statement.executeUpdate();

		ResultSet resultSet = statement.getGeneratedKeys();

		if(resultSet.next()){
			id = resultSet.getInt(1);
		}

		connection.close();

		return id;
	}

}
