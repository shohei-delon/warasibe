package com.internousdev.Warasibe.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Warasibe.dao.WishDAO;
import com.opensymphony.xwork2.ActionSupport;

public class RemoveWishItemAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	private int userId;
	private int myCommodityId;
	private int yourUserId;
	private int yourCommodityId;

	public String execute() {
		String result = ERROR;

		WishDAO dao = new WishDAO();

		try {
			dao.removeWishItem(userId, myCommodityId, yourUserId, yourCommodityId);
			result = SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getMyCommodityId() {
		return myCommodityId;
	}


	public void setMyCommodityId(int myCommodityId) {
		this.myCommodityId = myCommodityId;
	}


	public int getYourUserId() {
		return yourUserId;
	}


	public void setYourUserId(int yourUserId) {
		this.yourUserId = yourUserId;
	}


	public int getYourCommodityId() {
		return yourCommodityId;
	}


	public void setYourCommodityId(int yourCommodityId) {
		this.yourCommodityId = yourCommodityId;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

}
