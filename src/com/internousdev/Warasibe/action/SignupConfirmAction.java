package com.internousdev.Warasibe.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Warasibe.dao.SignupDAO;
import com.internousdev.Warasibe.dto.AccountDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SignupConfirmAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	private SignupDAO signupDAO = new SignupDAO();
	private AccountDTO accountDTO = new AccountDTO();

	private String result = ERROR;

	public String execute(){
		accountDTO = (AccountDTO) session.get("accountDTO");
		try {
			int id = signupDAO.userCreate(accountDTO);
			session.put("id",id);
			result = SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
