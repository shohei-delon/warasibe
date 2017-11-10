package com.internousdev.Warasibe.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Warasibe.dao.BelongsDAO;
import com.internousdev.Warasibe.dto.CommodityDTO;
import com.internousdev.Warasibe.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class ApplyingSelectAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	private int listIndex;

	private ArrayList<CommodityDTO> belongsList = new ArrayList<>();
	private CommodityDTO commodityDTO;

	public String execute() {
		String result = ERROR;

		BelongsDAO dao = new BelongsDAO();

		try {
			setBelongsList(dao.getBelongsItem(Integer.parseInt(session.get("id").toString())));

			@SuppressWarnings("unchecked")
			ArrayList<CommodityDTO> list = (ArrayList<CommodityDTO>) session.get(SessionName.getApplyingCommodityList());
			setCommodityDTO(list.get(listIndex));
			session.put(SessionName.getApplyingCommodityDto(), list.get(listIndex));
			session.remove(SessionName.getApplyingCommodityList());
			session.put(SessionName.getBelongsCommodityList(), getBelongsList());

			result = SUCCESS;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return result;
	}



	public int getListIndex() {
		return listIndex;
	}



	public void setListIndex(int listIndex) {
		this.listIndex = listIndex;
	}



	public ArrayList<CommodityDTO> getBelongsList() {
		return belongsList;
	}

	public void setBelongsList(ArrayList<CommodityDTO> belongsList) {
		this.belongsList = belongsList;
	}

	public CommodityDTO getCommodityDTO() {
		return commodityDTO;
	}



	public void setCommodityDTO(CommodityDTO commodityDTO) {
		this.commodityDTO = commodityDTO;
	}



	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession(){
		return this.session;
	}

}
