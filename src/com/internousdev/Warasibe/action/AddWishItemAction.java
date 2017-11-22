package com.internousdev.Warasibe.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Warasibe.dao.WishDAO;
import com.internousdev.Warasibe.dto.CommodityDTO;
import com.internousdev.Warasibe.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class AddWishItemAction extends ActionSupport implements SessionAware {

	private int userId;

	private Map<String, Object> session;

	//TODO CompleteApplyingActionに名前変更

	public String execute() {
		String result = ERROR;

		CommodityDTO myCommodityDTO = (CommodityDTO) session.get(SessionName.getBelongsCommodityDto());
		CommodityDTO yourCommodityDTO = (CommodityDTO) session.get(SessionName.getApplyingCommodityDto());

		try {
			WishDAO dao = new WishDAO();
			dao.addWishItem(myCommodityDTO.getPostId(), myCommodityDTO.getId(), yourCommodityDTO.getPostId(), yourCommodityDTO.getId());
			result = SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		session.remove(SessionName.getBelongsCommodityDto());
		session.remove(SessionName.getApplyingCommodityDto());

		return result;
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

	public Map<String, Object> getSession(){
		return this.session;
	}

}
