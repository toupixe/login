package com.wyd.login.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyd.login.dao.UserMapper;
import com.wyd.login.dto.UserDto;
import com.wyd.login.service.UserService;
import com.wyd.login.webutils.error.erroenum.EmBusinessError;
import com.wyd.login.webutils.exception.BusinessException;

@Service
public class UserServiceIpml implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void saveUser(UserDto userDto) throws BusinessException {
		userMapper.insertUser(userDto);
	}

	@Override
	public UserDto getUser(UserDto userDto) throws BusinessException {
		//如果用户传输对象为空，或者是，账号和手机号同时为空时
		if (userDto == null || (userDto.getLoginId() == null && userDto.getPhoneNumber() == null)) {
			throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "你所传入的参数有误");
		}
		//查询user对象
		UserDto resultUser = userMapper.selectUser(userDto);
		return resultUser;
		
		
	}

}
