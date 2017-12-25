package com.internousdev.Warasibe.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Warasibe.dao.TradeDAO;
import com.internousdev.Warasibe.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class CompleteTradingAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	@Override
	public String execute() {

		int wishInfoId = (int) session.get(SessionName.getWishInfoId());

		TradeDAO dao = new TradeDAO();
		try {
			dao.completeTrade(wishInfoId);
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ERROR;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

}
