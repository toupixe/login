package com.wyd.login.webutils.exception;

import com.wyd.login.webutils.error.CommonError;

public class BusinessException extends Exception implements CommonError{

	/**
	 * 序列化id
	 */
	private static final long serialVersionUID = 1L;
	
	private CommonError commonError;
	
	
	
	/*// 提供无参数的构造方法
	public BusinessException() { 
	} */

	// 提供一个有参数的构造方法，可自动生成
	public BusinessException(CommonError commonError) { 
		// 把参数传递给Throwable的带String参数的构造方法 
		super();
		this.commonError = commonError;
	}
	
	public BusinessException(CommonError commonError, String errorMsg) { 
		// 把参数传递给Throwable的带String参数的构造方法 
		super();
		this.commonError = commonError;
		this.setErrorMsg(errorMsg);
		
	}
	
	@Override
	public int getErrorCode() {
		return this.commonError.getErrorCode();
	}

	@Override
	public String getErrorMsg() {
		return this.commonError.getErrorMsg();
	}

	@Override
	public CommonError setErrorMsg(String msg) {
		this.commonError.setErrorMsg(msg);
		return this;
	} 
	
}
