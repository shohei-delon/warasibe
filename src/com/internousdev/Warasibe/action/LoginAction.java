package com.internousdev.Warasibe.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Warasibe.dao.LoginDAO;
import com.internousdev.Warasibe.dto.AccountDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	private String loginUserId;
	private String loginPassword;

	private LoginDAO loginDAO = new LoginDAO();
	private AccountDTO accountDTO = new AccountDTO();

	public Map<String, Object> session;

	public String execute(){
		if(!(loginUserId.equals("") || loginPassword.equals(""))){

			accountDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);

			session.put("accountDTO", accountDTO);
			if(((AccountDTO) session.get("accountDTO")).isLogin()){
				session.put("id", accountDTO.getId());
				return LOGIN;
			}
		}
		return ERROR;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
