package com.internousdev.Warasibe.dao;

import java.sql.SQLException;

import com.internousdev.Warasibe.dto.AccountDTO;

public interface AccountDAO {

	public AccountDTO getAccount(int id) throws SQLException;

}
