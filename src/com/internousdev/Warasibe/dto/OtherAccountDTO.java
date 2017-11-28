package com.internousdev.Warasibe.dto;

public class OtherAccountDTO {

	private int id;
	private String nickname;
	private String introduce;
	private float evaluation;
	private int trade_count;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public float getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(float evaluation) {
		this.evaluation = evaluation;
	}
	public int getTrade_count() {
		return trade_count;
	}
	public void setTrade_count(int trade_count) {
		this.trade_count = trade_count;
	}

}
