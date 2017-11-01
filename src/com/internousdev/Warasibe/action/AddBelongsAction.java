package com.internousdev.Warasibe.action;

import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Warasibe.dto.BelongsItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AddBelongsAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;

	private String name;
	private String detail;
	private int category_id;
	private int price;
	private String color;
	private float age;
	private float height;
	private float width;
	private float depth;
	private String size_unit;
	private Date postdate;
	private int user_id;
	private String result = ERROR;

	public String execute(){

		BelongsItemDTO dto = new BelongsItemDTO();
		dto.setName(name);
		dto.setDetail(detail);
		dto.setCategory_i(category_id);
		dto.setPrice(price);
		dto.setColor(color);
		dto.setAge(age);
		dto.setHeight(height);
		dto.setWidth(width);
		dto.setDepth(depth);
		dto.setSize_unit(size_unit);
		dto.setClose_trade(false);
		dto.setPostedDate(postdate);
		dto.setPostId(user_id);



		return result;
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

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
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

	public Date getPostdate() {
		return postdate;
	}

	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO 自動生成されたメソッド・スタブ
		this.session = session;
	}

}
