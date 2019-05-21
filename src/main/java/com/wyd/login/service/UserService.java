package com.wyd.login.service;

import com.wyd.login.dto.UserDto;
import com.wyd.login.webutils.exception.BusinessException;

public interface UserService {
	
	/**
	 * 
	 * <p>Title: saveUser</p>  
	 * <p>Description: 保存一条用户信息</p>  
	 * @param userDto
	 */
	public void saveUser(UserDto userDto)throws BusinessException;
	
	/**
	 * 
	 * <p>Title: saveUser</p>  
	 * <p>Description: 获取一条用户信息</p>  
	 * @param userDto user对象，但至少存在一个用户login_id或者手机号
	 * @throws BusinessException 
	 */
	public UserDto getUser(UserDto userDto) throws BusinessException;
}
