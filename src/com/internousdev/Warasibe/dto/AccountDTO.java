package com.internousdev.Warasibe.dto;

public class AccountDTO {

	private int id;
	private String loginUserId;
	private String loginPassword;
	private String mail;
	private String nickname;
	private float evaluation;

	private boolean login = false;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public float getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(float evaluation) {
		this.evaluation = evaluation;
	}
	public boolean isLogin() {
		return login;
	}
	public void setLogin(boolean login) {
		this.login = login;
	}

}
