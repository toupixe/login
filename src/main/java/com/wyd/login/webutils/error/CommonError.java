package com.wyd.login.webutils.error;

public interface CommonError {
	/**获取错误代码code*/
	public int getErrorCode();
	/**获取错误信息*/
	public String getErrorMsg();
	/**设置错误信息，并返回一个错误对象*/
	public CommonError setErrorMsg(String msg);
}
