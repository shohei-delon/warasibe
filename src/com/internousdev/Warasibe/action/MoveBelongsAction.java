package com.internousdev.Warasibe.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Warasibe.dao.BelongsDAO;
import com.internousdev.Warasibe.dto.BelongsItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MoveBelongsAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;

	private BelongsDAO dao = new BelongsDAO();
	public ArrayList<BelongsItemDTO> belongsList;

	private String result = ERROR;

	public String execute(){

		try {
			belongsList = dao.getBelongsItem(Integer.parseInt(session.get("id").toString()));
			result = SUCCESS;
		} catch (NumberFormatException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO 自動生成されたメソッド・スタブ
		this.session = session;
	}

}
