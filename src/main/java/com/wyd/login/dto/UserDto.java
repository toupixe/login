package com.wyd.login.dto;

import com.wyd.login.model.User;

public class UserDto extends User{
	/**验证码*/
	private String verification_code;

	/** 
	* 获取verification_code 
	* @return verification_code
	*/
	public String getVerification_code() {
		return verification_code;
	}

	/** 
	* 设置verification_code 
	* @param verification_code 
	*/
	public void setVerification_code(String verification_code) {
		this.verification_code = verification_code;
	}
	
	
}
