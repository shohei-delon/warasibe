package com.internousdev.Warasibe.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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
	private CommodityDTO yourCommodityDTO;

	@Override
	public String execute(){

		@SuppressWarnings("unchecked")
		LinkedHashMap<Integer[], CommodityDTO[]> appliedMap = (LinkedHashMap<Integer[], CommodityDTO[]>) session.get(SessionName.getAppliedCommodityMap());
		myCommodityDTO = new ArrayList<>(appliedMap.values()).get(0)[0];
		yourCommodityDTO = new ArrayList<>(appliedMap.values()).get(0)[1];

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

	public CommodityDTO getYourCommodityDTO() {
		return yourCommodityDTO;
	}

	public void setYourCommodityDTO(CommodityDTO yourCommodityDTO) {
		this.yourCommodityDTO = yourCommodityDTO;
	}

}
