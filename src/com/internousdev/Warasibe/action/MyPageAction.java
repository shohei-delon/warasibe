package com.internousdev.Warasibe.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Warasibe.dao.BelongsDAO;
import com.internousdev.Warasibe.dao.OtherAccountDAO;
import com.internousdev.Warasibe.dao.WishDAO;
import com.internousdev.Warasibe.dto.CommodityDTO;
import com.internousdev.Warasibe.dto.OtherAccountDTO;
import com.internousdev.Warasibe.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware {

	/*
	 * 画面遷移時に渡された情報群
	 */
	public Map<String, Object> session;
	// 画面遷移時に渡されたユーザーID
	private int userId;

	private OtherAccountDTO accountDTO = new OtherAccountDTO();

	/*
	 * 画面に表示する情報群
	 */

	private ArrayList<CommodityDTO> belongsList;
	// 申請が承認されているマップ
	private LinkedHashMap<Integer, CommodityDTO> agreedMap;
	// 申請されたマップ
	private LinkedHashMap<Integer[], CommodityDTO[]> appliedMap;
	// 申請したマップ
	private LinkedHashMap<Integer, CommodityDTO[]> wishMap;

	public String execute(){
		String result = ERROR;

		if(userId == 0) {
			userId = (int) session.get(SessionName.getId());
		}

		OtherAccountDAO accountDAO = new OtherAccountDAO();
		BelongsDAO belongsDAO = new BelongsDAO();
		WishDAO wishDAO = new WishDAO();
		try {
			setAccountDTO(accountDAO.getAccount(userId));
			setBelongsList(belongsDAO.getBelongsItem(userId));
			setAgreedMap(wishDAO.getAgreedMap(userId));
			setAppliedMap(wishDAO.getAppliedMap(userId));
			setWishMap(wishDAO.getWishMap(userId));

			if(userId != (int)session.get("id")) {
				session.put(SessionName.getApplyingCommodityList(), getBelongsList());
			}else {
				session.put(SessionName.getAppliedCommodityMap(), getAppliedMap());
				session.put(SessionName.getAgreedCommodityMap(), getAgreedMap());
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

	public LinkedHashMap<Integer, CommodityDTO> getAgreedMap() {
		return agreedMap;
	}


	public void setAgreedMap(LinkedHashMap<Integer, CommodityDTO> agreedMap) {
		this.agreedMap = agreedMap;
	}


	public LinkedHashMap<Integer[], CommodityDTO[]> getAppliedMap() {
		return appliedMap;
	}


	public void setAppliedMap(LinkedHashMap<Integer[], CommodityDTO[]> appliedMap) {
		this.appliedMap = appliedMap;
	}


	public LinkedHashMap<Integer, CommodityDTO[]> getWishMap() {
		return wishMap;
	}


	public void setWishMap(LinkedHashMap<Integer, CommodityDTO[]> wishMap) {
		this.wishMap = wishMap;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
