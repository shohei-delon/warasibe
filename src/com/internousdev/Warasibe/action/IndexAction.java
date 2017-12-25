package com.internousdev.Warasibe.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Warasibe.dao.CategoryDAO;
import com.internousdev.Warasibe.dao.OtherAccountDAO;
import com.internousdev.Warasibe.dto.OtherAccountDTO;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private ArrayList<String> categoryList;
	private ArrayList<OtherAccountDTO> firstTopicList;
	private ArrayList<OtherAccountDTO> secondTopicList;

	private CategoryDAO indexDao = new CategoryDAO();
	private OtherAccountDAO firstTopicAccountDAO = new OtherAccountDAO();
	private OtherAccountDAO secondTopicAccountDAO = new OtherAccountDAO();

	public String execute(){

		try {
			categoryList = indexDao.getCategoryList();
			setFirstTopicList(firstTopicAccountDAO.getAccountTradeCount());
			setSecondTopicList(secondTopicAccountDAO.getAccountEvaluation());
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

	public ArrayList<String> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(ArrayList<String> categoryList) {
		this.categoryList = categoryList;
	}

	public ArrayList<OtherAccountDTO> getFirstTopicList() {
		return firstTopicList;
	}

	public void setFirstTopicList(ArrayList<OtherAccountDTO> firstTopicList) {
		this.firstTopicList = firstTopicList;
	}

	public ArrayList<OtherAccountDTO> getSecondTopicList() {
		return secondTopicList;
	}

	public void setSecondTopicList(ArrayList<OtherAccountDTO> secondTopicList) {
		this.secondTopicList = secondTopicList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public CategoryDAO getIndexDao() {
		return indexDao;
	}

	public void setIndexDao(CategoryDAO indexDao) {
		this.indexDao = indexDao;
	}

	public OtherAccountDAO getFirstTopicAccountDAO() {
		return firstTopicAccountDAO;
	}

	public void setFirstTopicAccountDAO(OtherAccountDAO firstTopicAccountDAO) {
		this.firstTopicAccountDAO = firstTopicAccountDAO;
	}

	public OtherAccountDAO getSecondTopicAccountDAO() {
		return secondTopicAccountDAO;
	}

	public void setSecondTopicAccountDAO(OtherAccountDAO secondTopicAccountDAO) {
		this.secondTopicAccountDAO = secondTopicAccountDAO;
	}

}
