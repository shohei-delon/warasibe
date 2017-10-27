package com.internousdev.Warasibe.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Warasibe.dto.AccountDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SignupAction extends ActionSupport implements SessionAware {

	private String signupUserId;
	private String signupPassword;
	private String nickname;
	private String mail;

	private AccountDTO accountDTO = new AccountDTO();

	public Map<String, Object> session;

	public String message;
	private String result = ERROR;

	public String execute(){
		if(validInput()){
			accountDTO.setLoginUserId(signupUserId);
			accountDTO.setLoginPassword(signupPassword);
			accountDTO.setNickname(nickname);
			accountDTO.setMail(mail);
			session.put("accountDTO", accountDTO);
			result = SUCCESS;
		}
		return result;
	}

	private boolean validInput(){
		StringBuilder sb = new StringBuilder();
		if(signupUserId.equals("")){
			sb.append("IDが不適当です。");
		}else if(signupPassword.equals("")){
			sb.append("passwordが不適当です。");
		}else if(nickname.equals("")){
			sb.append("usernameが不適当です。");
		}else if(mail.equals("")){
			sb.append("メールアドレスが不適当です。");
		}else{
			return true;
		}
		message = sb.toString();
		System.out.println("errorMessage:"+message);
		return false;
	}

	public String getSignupUserId() {
		return signupUserId;
	}

	public void setSignupUserId(String signupUserId) {
		this.signupUserId = signupUserId;
	}

	public String getSignupPassword() {
		return signupPassword;
	}

	public void setSignupPassword(String signupPassword) {
		this.signupPassword = signupPassword;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
