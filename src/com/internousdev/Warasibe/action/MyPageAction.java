package com.internousdev.Warasibe.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Warasibe.dao.BelongsDAO;
import com.internousdev.Warasibe.dao.OtherAccountDAO;
import com.internousdev.Warasibe.dao.WishDAO;
import com.internousdev.Warasibe.dto.CommodityDTO;
import com.internousdev.Warasibe.dto.OtherAccountDTO;
import com.internousdev.Warasibe.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private int userId;

	private OtherAccountDTO accountDTO = new OtherAccountDTO();

	private ArrayList<CommodityDTO> belongsList;
	private Set<Map.Entry<OtherAccountDTO, CommodityDTO[]>> appliedMap;
	private Set<Map.Entry<OtherAccountDTO, CommodityDTO[]>> wishMap;

	private String result = ERROR;

	public String execute(){
		OtherAccountDAO accountDAO = new OtherAccountDAO();
		BelongsDAO belongsDAO = new BelongsDAO();
		WishDAO wishDAO = new WishDAO();
		try {
			setBelongsList(belongsDAO.getBelongsItem(userId));
			setAccountDTO(accountDAO.getAccount(userId));
			setAppliedMap(wishDAO.getAppliedMap(userId).entrySet());
			setWishMap(wishDAO.getWishMap(userId).entrySet());

			if(userId != (int)session.get("id")) {
				session.put(SessionName.getApplyingCommodityList(), belongsList);
			}

			result = SUCCESS;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}


	public void addApplying(CommodityDTO commodityDTO) {
		session.put("ApplyingCommodityDTO", commodityDTO);
	}

	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public OtherAccountDTO getAccountDTO() {
		return accountDTO;
	}



	public void setAccountDTO(OtherAccountDTO accountDTO) {
		this.accountDTO = accountDTO;
	}


	public ArrayList<CommodityDTO> getBelongsList() {
		return belongsList;
	}



	public void setBelongsList(ArrayList<CommodityDTO> belongsList) {
		this.belongsList = belongsList;
	}



	public Set<Map.Entry<OtherAccountDTO, CommodityDTO[]>> getAppliedMap() {
		return appliedMap;
	}



	public void setAppliedMap(Set<Map.Entry<OtherAccountDTO, CommodityDTO[]>> appliedMap) {
		this.appliedMap = appliedMap;
	}



	public Set<Map.Entry<OtherAccountDTO, CommodityDTO[]>> getWishMap() {
		return wishMap;
	}



	public void setWishMap(Set<Map.Entry<OtherAccountDTO, CommodityDTO[]>> wishMap) {
		this.wishMap = wishMap;
	}



	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
