package com.internousdev.Warasibe.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Warasibe.dao.IndexDAO;
import com.internousdev.Warasibe.dao.OtherAccountDAO;
import com.internousdev.Warasibe.dto.OtherAccountDTO;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	public ArrayList<String> categoryList;
	public ArrayList<OtherAccountDTO> firstTopicList;
	public ArrayList<OtherAccountDTO> secondTopicList;

	private IndexDAO indexDao = new IndexDAO();
	private OtherAccountDAO firstTopicAccountDAO = new OtherAccountDAO();
	private OtherAccountDAO secondTopicAccountDAO = new OtherAccountDAO();

	private String result = ERROR;

	public String execute(){

		try {
			categoryList = indexDao.getCategory();
			firstTopicList = firstTopicAccountDAO.getAccountTradeCount();
			secondTopicList = secondTopicAccountDAO.getAccountEvaluation();
			result = SUCCESS;
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
