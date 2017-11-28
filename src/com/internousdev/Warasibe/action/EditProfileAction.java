package com.internousdev.Warasibe.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Warasibe.dao.LoginDAO;
import com.internousdev.Warasibe.dto.AccountDTO;
import com.internousdev.Warasibe.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class EditProfileAction extends ActionSupport implements SessionAware {

	private String loginId;
	private String loginPassword;
	private String nickname;
	private String introduce;

	private AccountDTO accountDTO;

	private Map<String, Object> session;

	private int userId;
	private String message;

	public String execute() {

		userId = (int) session.get(SessionName.getId());
		accountDTO = (AccountDTO) session.get(SessionName.getAccountDto());

		LoginDAO dao = new LoginDAO();
		try {
			if(loginId==null || loginPassword==null || nickname==null || introduce==null) {
				message = "未入力の項目があります。";
				return "back";
			}else if(!accountDTO.getLoginUserId().equals(loginId) || !accountDTO.getLoginPassword().equals(loginPassword)) {
				message = "ログインIDかPasswordが間違っています。";
				return "back";
			}else {
				dao.updateAccount(userId, nickname, introduce);
				return SUCCESS;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ERROR;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public AccountDTO getAccountDTO() {
		return accountDTO;
	}
	public void setAccountDTO(AccountDTO accountDTO) {
		this.accountDTO = accountDTO;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
