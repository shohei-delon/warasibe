package com.internousdev.Warasibe.dto;

import java.util.Date;

public class BelongsItemDTO {

	private int postId;
	private String name;
	private String detail;
	public String category;
	private int category_i;
	private int price;
	private String color;
	private float age;
	private float height;
	private float width;
	private float depth;
	private String size_unit;
	private boolean close_trade;
	private Date postedDate;

	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getCategory_i() {
		return category_i;
	}
	public void setCategory_i(int category_i) {
		this.category_i = category_i;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public float getAge() {
		return age;
	}
	public void setAge(float age) {
		this.age = age;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	public float getDepth() {
		return depth;
	}
	public void setDepth(float depth) {
		this.depth = depth;
	}
	public String getSize_unit() {
		return size_unit;
	}
	public void setSize_unit(String size_unit) {
		this.size_unit = size_unit;
	}
	public boolean isClose_trade() {
		return close_trade;
	}
	public void setClose_trade(boolean close_trade) {
		this.close_trade = close_trade;
	}
	public Date getPostedDate() {
		return postedDate;
	}
	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}
}
