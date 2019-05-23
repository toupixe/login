package com.wyd.login.model;

import java.util.Date;

public class Loading{

	private Integer id;
	private String device;
	private String url;
	private Date time;
	private String isComputor;
	/** 
	* 获取id 
	* @return id
	*/
	public Integer getId() {
		return id;
	}
	/** 
	* 设置id 
	* @param id 
	*/
	public void setId(Integer id) {
		this.id = id;
	}
	/** 
	* 获取device 
	* @return device
	*/
	public String getDevice() {
		return device;
	}
	/** 
	* 设置device 
	* @param device 
	*/
	public void setDevice(String device) {
		this.device = device;
	}
	/** 
	* 获取url 
	* @return url
	*/
	public String getUrl() {
		return url;
	}
	/** 
	* 设置url 
	* @param url 
	*/
	public void setUrl(String url) {
		this.url = url;
	}
	/** 
	* 获取time 
	* @return time
	*/
	public Date getTime() {
		return time;
	}
	/** 
	* 设置time 
	* @param time 
	*/
	public void setTime(Date time) {
		this.time = time;
	}
	/** 
	* 获取isComputor 
	* @return isComputor
	*/
	public String getIsComputor() {
		return isComputor;
	}
	/** 
	* 设置isComputor 
	* @param isComputor 
	*/
	public void setIsComputor(String isComputor) {
		this.isComputor = isComputor;
	}
	
	
	
}
