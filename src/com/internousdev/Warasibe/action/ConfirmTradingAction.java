package com.internousdev.Warasibe.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Warasibe.dao.TradeDAO;
import com.internousdev.Warasibe.dao.WishDAO;
import com.internousdev.Warasibe.dto.CommodityDTO;
import com.internousdev.Warasibe.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class ConfirmTradingAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private int listIndex;
	private boolean fromArrive;
	private boolean fromReview;

	private CommodityDTO myCommodityDTO;
	private CommodityDTO yourCommodityDTO;

	private int yourId;
	private int userId;

	private String message;


	private TradeDAO tradeDAO = new TradeDAO();


	@Override
	public String execute() {
		@SuppressWarnings("unchecked")
		LinkedHashMap<Integer, CommodityDTO[]> appliedMap = (LinkedHashMap<Integer, CommodityDTO[]>) session.get(SessionName.getAgreedCommodityMap());
		myCommodityDTO = new ArrayList<>(appliedMap.values()).get(listIndex)[0];
		yourCommodityDTO = new ArrayList<>(appliedMap.values()).get(listIndex)[1];

		ArrayList<Integer> wishInfoIdList = new ArrayList<>(appliedMap.keySet());

		int wishInfoId = wishInfoIdList.get(listIndex);

		session.put(SessionName.getWishInfoId(), wishInfoId);

		userId = (int) session.get(SessionName.getId());

		String result = ERROR;

		try {
			WishDAO wishDAO = new WishDAO();
			switch(tradeDAO.getStatus(wishInfoId)){
			case 0:
				// error
				break;
			case 1:
				if(fromArrive) {
					tradeDAO.addArrived(wishInfoId, userId);
					tradeDAO.setStatus(wishInfoId);
				}
				if(tradeDAO.isArrived(wishInfoId, userId)) {
					message = "相手方の到着をお待ち下さい。";
				}
				result = SUCCESS;
				break;
			case 2:
				if(fromArrive) {
					tradeDAO.addArrived(wishInfoId, userId);
					tradeDAO.setStatus(wishInfoId);
					result = "arrived";
				}else {
					result = SUCCESS;
				}
				break;
			case 3:
				if(fromReview) {
					tradeDAO.addReviewed(wishInfoId, userId);
					tradeDAO.setStatus(wishInfoId);
					if(tradeDAO.isReviewed(wishInfoId, userId)) {
						message = "相手方の評価をお待ち下さい。";
					}
					result = "reviewed";
				}else {
					yourId = wishDAO.getYourId(wishInfoId, userId);
					result = "arrived";
				}
				break;
			case 4:
				if(fromReview) {
					tradeDAO.addReviewed(wishInfoId, userId);
					tradeDAO.setStatus(wishInfoId);

					result = "complete";
				}else {
					yourId = wishDAO.getYourId(wishInfoId, userId);
					if(tradeDAO.isReviewed(wishInfoId, userId)) {
						result = "reviewed";
					}else {
						result = "arrived";
					}
				}

				break;
			case 5:
				result = "complete";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean checkArrived() {
		int wishInfoId = (int) session.get(SessionName.getWishInfoId());

		try {
			return !tradeDAO.isArrived(wishInfoId, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}


	public int getListIndex() {
		return listIndex;
	}


	public void setListIndex(int listIndex) {
		this.listIndex = listIndex;
	}


	public boolean isFromArrive() {
		return fromArrive;
	}


	public void setFromArrive(boolean fromArrive) {
		this.fromArrive = fromArrive;
	}


	public boolean isFromReview() {
		return fromReview;
	}


	public void setFromReview(boolean fromReview) {
		this.fromReview = fromReview;
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

	public int getYourId() {
		return yourId;
	}


	public void setYourId(int yourId) {
		this.yourId = yourId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Map<String, Object> getSession() {
		return session;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
