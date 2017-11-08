package com.internousdev.Warasibe.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Warasibe.dao.BelongsDAO;
import com.internousdev.Warasibe.dao.LinkWishDAO;
import com.internousdev.Warasibe.dao.OtherAccountDAO;
import com.internousdev.Warasibe.dao.WishDAO;
import com.internousdev.Warasibe.dto.CommodityDTO;
import com.internousdev.Warasibe.dto.OtherAccountDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private int userId;

	private OtherAccountDTO accountDTO = new OtherAccountDTO();

	private ArrayList<CommodityDTO> wishList;
	public ArrayList<CommodityDTO> belongsList;
	private Set<Map.Entry<OtherAccountDTO, CommodityDTO[]>> linkWishMap;

	private String result = ERROR;

	public String execute(){
		OtherAccountDAO accountDAO = new OtherAccountDAO();
		WishDAO wishDAO = new WishDAO();
		BelongsDAO belongsDAO = new BelongsDAO();
		LinkWishDAO linkWishDAO = new LinkWishDAO();
		try {
			setAccountDTO(accountDAO.getAccount(userId));
			wishList = wishDAO.getWishList(userId);
			belongsList = belongsDAO.getBelongsItem(userId);
			setLinkWishMap(linkWishDAO.getEachWishMap(userId).entrySet());
			result = SUCCESS;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
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



	public ArrayList<CommodityDTO> getWishList() {
		return wishList;
	}



	public void setWishList(ArrayList<CommodityDTO> wishList) {
		this.wishList = wishList;
	}




	public Set<Map.Entry<OtherAccountDTO, CommodityDTO[]>> getLinkWishMap() {
		return linkWishMap;
	}



	public void setLinkWishMap(Set<Map.Entry<OtherAccountDTO, CommodityDTO[]>> linkWishMap) {
		this.linkWishMap = linkWishMap;
	}



	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
