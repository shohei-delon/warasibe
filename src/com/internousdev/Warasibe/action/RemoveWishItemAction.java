package com.internousdev.Warasibe.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Warasibe.dao.WishDAO;
import com.opensymphony.xwork2.ActionSupport;

public class RemoveWishItemAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	private int userId;
	private int commodityId;

	public String execute() {
		String result = ERROR;

		WishDAO dao = new WishDAO();
		try {
			dao.removeWishItem(userId, commodityId);
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

	public int getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}



	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

}
