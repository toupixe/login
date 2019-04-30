package com.wyd.login.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wyd.login.dto.UserDto;

@Repository
public interface UserMapper {
	/**
	 * 
	 * <p>Title: insertUser</p>  
	 * <p>Description:保存一个用户 </p>  
	 * @param userDto 用户数据传输类
	 */
	void insertUser(@Param("userDto") UserDto userDto);
	
	UserDto selectUser(@Param("userDto") UserDto userDto);
}
