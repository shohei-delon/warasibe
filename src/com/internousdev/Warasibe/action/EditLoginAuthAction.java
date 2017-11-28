package com.internousdev.Warasibe.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Warasibe.dao.LoginDAO;
import com.internousdev.Warasibe.dto.AccountDTO;
import com.internousdev.Warasibe.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class EditLoginAuthAction extends ActionSupport implements SessionAware {

	private String oldId;
	private String oldPassword;
	private String newId;
	private String newPassword;

	private AccountDTO accountDTO;
	private Map<String, Object> session;

	private int userId;
	private String message;

	public String execute() {

		userId = (int) session.get(SessionName.getId());
		accountDTO = (AccountDTO) session.get(SessionName.getAccountDto());

		LoginDAO accountDAO = new LoginDAO();
		if (oldId==null || oldPassword==null || newId==null || newPassword==null) {
			message="未入力の項目があります。";
			return "back";
		}else if(!accountDTO.getLoginUserId().equals(oldId) || !accountDTO.getLoginPassword().equals(oldPassword)) {
			message="現在のログイン情報が間違えてます。";
			return "back";
		}else {
			try {
				accountDAO.updateLoginAuth(userId, newId, newPassword);
				return SUCCESS;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return ERROR;
	}

	public AccountDTO getAccountDTO() {
		return accountDTO;
	}

	public void setAccountDTO(AccountDTO accountDTO) {
		this.accountDTO = accountDTO;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getOldId() {
		return oldId;
	}

	public void setOldId(String oldId) {
		this.oldId = oldId;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewId() {
		return newId;
	}

	public void setNewId(String newId) {
		this.newId = newId;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
