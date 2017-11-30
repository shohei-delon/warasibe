package com.internousdev.Warasibe.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BackSignupAction extends ActionSupport implements SessionAware {

	private String signupUserId;
	private String signupPassword;
	private String nickname;
	private String mail;

	private Map<String, Object> session;

	private String message;

	public String execute() {
		System.out.println(signupUserId);
		return SUCCESS;
	}

	//TODO フォーム内に2個のサブミットが機能しない

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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {

	}

}
