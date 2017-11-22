package com.internousdev.Warasibe.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Warasibe.dao.WishDAO;
import com.internousdev.Warasibe.dto.CommodityDTO;
import com.internousdev.Warasibe.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class CompleteDisagreementAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private int listIndex;

	private CommodityDTO myCommodityDTO;
	private CommodityDTO yourCommodityDTO;

	public String execute() {

		@SuppressWarnings("unchecked")
		LinkedHashMap<Integer, CommodityDTO> appliedMap = (LinkedHashMap<Integer, CommodityDTO>) session.get(SessionName.getAgreedCommodityMap());
		myCommodityDTO = new ArrayList<>(appliedMap.values()).get(listIndex);

		ArrayList<Integer> wishInfoIdList = new ArrayList<>(appliedMap.keySet());

		int wishInfoId = wishInfoIdList.get(listIndex);

		WishDAO wishDAO = new WishDAO();
		try {
			wishDAO.removeWishItem(wishInfoId);
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ERROR;
	}

	public int getListIndex() {
		return listIndex;
	}

	public void setListIndex(int listIndex) {
		this.listIndex = listIndex;
	}

	public CommodityDTO getMyCommodityDTO() {
		return myCommodityDTO;
	}

	public void setMyCommodityDTO(CommodityDTO myCommodityDTO) {
		this.myCommodityDTO = myCommodityDTO;
	}

	public CommodityDTO getYourCommodityDTO() {
		return yourCommodityDTO;
	}

	public void setYourCommodityDTO(CommodityDTO yourCommodityDTO) {
		this.yourCommodityDTO = yourCommodityDTO;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
