package com.internousdev.Warasibe.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Warasibe.dao.SignupDAO;
import com.internousdev.Warasibe.dto.AccountDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SignupConfirmAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	public String execute(){
		SignupDAO signupDAO = new SignupDAO();
		AccountDTO accountDTO = new AccountDTO();
		accountDTO = (AccountDTO) session.get("accountDTO");
		try {
			int id = signupDAO.userCreate(accountDTO);
			session.put("id",id);
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ERROR;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
