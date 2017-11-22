package com.internousdev.Warasibe.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Warasibe.dao.TradeDAO;
import com.internousdev.Warasibe.dto.CommodityDTO;
import com.internousdev.Warasibe.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class AgreeTradingAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	private String messege;
	private CommodityDTO myCommodityDTO;

	@Override
	public String execute(){

		myCommodityDTO = (CommodityDTO) session.get(SessionName.getMyCommodityDto());

		int wishInfoId = (int) session.get(SessionName.getWishInfoId());
		TradeDAO dao = new TradeDAO();
		try {
			dao.AgreeTrade(wishInfoId);
			messege = "交換申請を承認しました。";
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public CommodityDTO getMyCommodityDTO() {
		return myCommodityDTO;
	}

	public void setMyCommodityDTO(CommodityDTO myCommodityDTO) {
		this.myCommodityDTO = myCommodityDTO;
	}

	public String getMessege() {
		return messege;
	}

	public void setMessege(String messege) {
		this.messege = messege;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
