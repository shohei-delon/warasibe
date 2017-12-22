package com.internousdev.Warasibe.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Warasibe.dao.BelongsDAO;
import com.internousdev.Warasibe.dao.CategoryDAO;
import com.internousdev.Warasibe.dto.CommodityDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MoveBelongsAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;

	private BelongsDAO belongsDAO = new BelongsDAO();
	private CategoryDAO categoryDAO = new CategoryDAO();

	private ArrayList<CommodityDTO> belongsList;
	private Map<Integer, String> categoryMap;

	public String execute(){

		try {
			belongsList = belongsDAO.getBelongsItem(Integer.parseInt(session.get("id").toString()));
			categoryMap = categoryDAO.getCategoryMap();
			return SUCCESS;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ERROR;
	}

	public ArrayList<CommodityDTO> getBelongsList() {
		return belongsList;
	}

	public void setBelongsList(ArrayList<CommodityDTO> belongsList) {
		this.belongsList = belongsList;
	}

	public Map<Integer, String> getCategoryMap() {
		return categoryMap;
	}

	public void setCategoryMap(Map<Integer, String> categoryMap) {
		this.categoryMap = categoryMap;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
