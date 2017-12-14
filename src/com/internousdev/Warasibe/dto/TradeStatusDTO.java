package com.internousdev.Warasibe.dto;

public class TradeStatusDTO {

	private int id;
	private int wishInfoId;
	private String tradeStartDate;
	private boolean commodity1Delivered;
	private boolean commodity2Delivered;
	private boolean complete;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWishInfoId() {
		return wishInfoId;
	}
	public void setWishInfoId(int wishInfoId) {
		this.wishInfoId = wishInfoId;
	}
	public String getTradeStartDate() {
		return tradeStartDate;
	}
	public void setTradeStartDate(String tradeStartDate) {
		this.tradeStartDate = tradeStartDate;
	}
	public boolean isCommodity1Delivered() {
		return commodity1Delivered;
	}
	public void setCommodity1Delivered(boolean commodity1Delivered) {
		this.commodity1Delivered = commodity1Delivered;
	}
	public boolean isCommodity2Delivered() {
		return commodity2Delivered;
	}
	public void setCommodity2Delivered(boolean commodity2Delivered) {
		this.commodity2Delivered = commodity2Delivered;
	}
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}

}
