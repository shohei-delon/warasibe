package com.internousdev.Warasibe.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Warasibe.dao.CategoryDAO;
import com.internousdev.Warasibe.dao.SearchDAO;
import com.internousdev.Warasibe.dto.CommodityDTO;
import com.internousdev.Warasibe.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport implements SessionAware {

	private String searchText;
	private int searchCategory;
	private int userId;

	private ArrayList<CommodityDTO> itemList;
	private ArrayList<String> categoryList;
	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;
		SearchDAO searchDAO = new SearchDAO();
		CategoryDAO categoryDAO = new CategoryDAO();

		if(session.get(SessionName.getId()) != null){
			userId = (int)session.get(SessionName.getId());
		}else{
			result = "login";
		}

		try {
			setCategoryList(categoryDAO.getCategoryList());

			if(searchText != null && searchCategory != 0) {
				setItemList(searchDAO.searchItem(searchText, searchCategory, userId));
			}else if(searchText != null) {
				setItemList(searchDAO.searchItem(searchText, userId));
			}else if(searchCategory != 0) {
				setItemList(searchDAO.searchItem(searchCategory, userId));
				searchText = "指定無し";
			}else {
				setItemList(searchDAO.searchItem(userId));
				searchText = "指定無し";
			}

			session.put(SessionName.getApplyingCommodityList(), itemList);

			result = SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public int getSearchCategory() {
		return searchCategory;
	}

	public void setSearchCategory(int searchCategory) {
		this.searchCategory = searchCategory;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public ArrayList<CommodityDTO> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<CommodityDTO> itemList) {
		this.itemList = itemList;
	}

	public ArrayList<String> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(ArrayList<String> categoryList) {
		this.categoryList = categoryList;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public Map<String, Object> getSession() {
		return session;
	}

}
