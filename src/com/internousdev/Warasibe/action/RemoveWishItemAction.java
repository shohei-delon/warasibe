package com.internousdev.Warasibe.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Warasibe.dao.WishDAO;
import com.internousdev.Warasibe.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class RemoveWishItemAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	private int userId;
	private int wishInfoId;

	public String execute() {

		userId = (int) session.get(SessionName.getId());

		WishDAO dao = new WishDAO();
		if(wishInfoId == 0) wishInfoId = (int) session.get(SessionName.getWishInfoId());

		try {
			dao.removeWishItem(wishInfoId);
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ERROR;
	}

	public int getWishInfoId() {
		return wishInfoId;
	}

	public void setWishInfoId(int wishInfoId) {
		this.wishInfoId = wishInfoId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

}
