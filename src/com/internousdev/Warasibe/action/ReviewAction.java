package com.internousdev.Warasibe.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Warasibe.dao.OtherAccountDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ReviewAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private int yourId;
	private int rate;

	private boolean fromReview = true;

	public String execute() {
		OtherAccountDAO dao = new OtherAccountDAO();
		try {
			dao.setEvaluation(rate, yourId);
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ERROR;
	}

	public int getYourId() {
		return yourId;
	}

	public void setYourId(int yourId) {
		this.yourId = yourId;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public boolean isFromReview() {
		return fromReview;
	}

	public void setFromReview(boolean fromReview) {
		this.fromReview = fromReview;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
