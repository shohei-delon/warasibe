package com.internousdev.Warasibe.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Warasibe.dto.CommodityDTO;
import com.internousdev.Warasibe.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class ConfirmApplyingAction extends ActionSupport implements SessionAware {

	//TODO ApplyingConfirmActionに名前変更

	private int belongsId;

	private CommodityDTO myCommodityDTO;
	private CommodityDTO wantCommodityDTO;

	private Map<String, Object> session;

	public String execute() {
		//TODO ここまでやった

		@SuppressWarnings("unchecked")
		ArrayList<CommodityDTO> list = (ArrayList<CommodityDTO>) session.get(SessionName.getBelongsCommodityList());
		session.put(SessionName.getBelongsCommodityDto(), list.get(belongsId));
		myCommodityDTO = list.get(belongsId);

		wantCommodityDTO = (CommodityDTO) session.get(SessionName.getApplyingCommodityDto());

		session.remove(SessionName.getBelongsCommodityList());

		return SUCCESS;
	}

	public int getBelongsId() {
		return belongsId;
	}

	public void setBelongsId(int belongsId) {
		this.belongsId = belongsId;
	}

	public CommodityDTO getMyCommodityDTO() {
		return myCommodityDTO;
	}

	public void setMyCommodityDTO(CommodityDTO myCommodityDTO) {
		this.myCommodityDTO = myCommodityDTO;
	}

	public CommodityDTO getWantCommodityDTO() {
		return wantCommodityDTO;
	}

	public void setWantCommodityDTO(CommodityDTO wantCommodityDTO) {
		this.wantCommodityDTO = wantCommodityDTO;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

}
