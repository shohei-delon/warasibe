package com.internousdev.Warasibe.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Warasibe.dto.CommodityDTO;
import com.internousdev.Warasibe.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class ConfirmAgreementAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private int listIndex;
	private String flag;

	private CommodityDTO myCommodityDTO;
	private CommodityDTO yourCommodityDTO;


	public String execute() {

		@SuppressWarnings("unchecked")
		LinkedHashMap<Integer[], CommodityDTO[]> appliedMap = (LinkedHashMap<Integer[], CommodityDTO[]>) session.get(SessionName.getAppliedCommodityMap());
		CommodityDTO[] commoditySet = new ArrayList<>(appliedMap.values()).get(listIndex);
		session.put(SessionName.getMyCommodityDto(), commoditySet[0]);

		ArrayList<Integer[]> wishInfoList = new ArrayList<>(appliedMap.keySet());

		int wishInfoId = wishInfoList.get(listIndex)[1];
		session.put(SessionName.getWishInfoId(), wishInfoId);
		myCommodityDTO = commoditySet[0];
		yourCommodityDTO = commoditySet[1];

		if(flag == null) {
			return SUCCESS;
		}else {
			return "delete";
		}

	}

	public int getListIndex() {
		return listIndex;
	}

	public void setListIndex(int listIndex) {
		this.listIndex = listIndex;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
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
		this.session= session;
	}

}
