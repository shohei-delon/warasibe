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

	public ArrayList<CommodityDTO> belongsList;
	public Map<Integer, String> categoryMap;

	private String result = ERROR;

	public String execute(){

		try {
			belongsList = belongsDAO.getBelongsItem(Integer.parseInt(session.get("id").toString()));
			categoryMap = categoryDAO.getCategoryMap();
			result = SUCCESS;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
