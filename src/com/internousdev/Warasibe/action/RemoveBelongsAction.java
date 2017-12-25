package com.internousdev.Warasibe.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Warasibe.dao.BelongsDAO;
import com.opensymphony.xwork2.ActionSupport;

public class RemoveBelongsAction extends ActionSupport implements SessionAware {

	private int itemId;
	public Map<String, Object> session;

	private BelongsDAO dao = new BelongsDAO();

	public String execute() {

		try {
			dao.removeBelongsItem(itemId);
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ERROR;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

}
