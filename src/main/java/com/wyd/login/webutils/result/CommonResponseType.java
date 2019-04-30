package com.wyd.login.webutils.result;

public class CommonResponseType {
	/**响应状态，成功success，失败failed*/
	private String stauts;
	/**响应返回的数据*/
	private Object data;
	
	/**通用的创建方法*/
	public static CommonResponseType create(Object result) {
		return CommonResponseType.create(result,Result.SUCCESS.getStauts());
		
	}
	/**如果创建方法中传递参数具有响应状态和响应数据*/
	public static CommonResponseType create(Object result,String stauts) {
		CommonResponseType type = new CommonResponseType();
		type.setStauts(stauts);
		type.setData(result);
		return type;
		
	}
	
	/**
	 * @return the stauts
	 */
	public String getStauts() {
		return stauts;
	}
	/**
	 * @param stauts the stauts to set
	 */
	public void setStauts(String stauts) {
		this.stauts = stauts;
	}
	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}
	
}
