package com.wxkj.wanjia.entity;

import java.io.Serializable;

public class WanJiaEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	private String w_id;
	private String w_name;
	private String w_sex;
	private String w_like;
	public String getW_id() {
		return w_id;
	}
	public void setW_id(String w_id) {
		this.w_id = w_id;
	}
	public String getW_name() {
		return w_name;
	}
	public void setW_name(String w_name) {
		this.w_name = w_name;
	}
	public String getW_sex() {
		return w_sex;
	}
	public void setW_sex(String w_sex) {
		this.w_sex = w_sex;
	}
	public String getW_like() {
		return w_like;
	}
	public void setW_like(String w_like) {
		this.w_like = w_like;
	}
	
}
