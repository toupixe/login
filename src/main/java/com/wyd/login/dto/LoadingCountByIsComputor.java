package com.wyd.login.dto;

import java.io.Serializable;

public class LoadingCountByIsComputor implements Serializable{
	/** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	private String isComputor;
	private Integer count;
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
	/** 
	* 获取count 
	* @return count
	*/
	public Integer getCount() {
		return count;
	}
	/** 
	* 设置count 
	* @param count 
	*/
	public void setCount(Integer count) {
		this.count = count;
	}
	
	
}
