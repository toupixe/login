package com.wyd.login.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.support.json.JSONUtils;
import com.wyd.login.dto.UserDto;
import com.wyd.login.model.User;
import com.wyd.login.service.UserService;
import com.wyd.login.webutils.error.erroenum.EmBusinessError;
import com.wyd.login.webutils.exception.BusinessException;
import com.wyd.login.webutils.result.CommonResponseType;
import com.wyd.login.webutils.result.Result;

import redis.clients.jedis.Jedis;

@Controller()
@RequestMapping("/login")
@CrossOrigin(allowCredentials="true",allowedHeaders="*")
public class LoginController extends BaseController{
	
	@Autowired
	private HttpServletRequest httpServletRequest;
	
	/**用户Service*/
	@Autowired
	private UserService userService;
	
	/**新用户注册*/
	@RequestMapping("/regist")
	@ResponseBody
	public CommonResponseType regist(User user, String verification_code) {
		Map<String, Object> map = new HashMap<>();
		//获取验证码
		String otp = (String) httpServletRequest.getSession().getAttribute(user.getPhoneNumber());
		if (!otp.equals(verification_code)) {
			map.put("errorCode", EmBusinessError.OTP_IS_ERROR.getErrorCode());
			map.put("errorMsg", EmBusinessError.OTP_IS_ERROR.getErrorMsg());
			return CommonResponseType.create(map, Result.FAIL.getStauts());
		} 
		
		//判断参数是否正确
		
		//将用户保存
		UserDto userDto = new UserDto();
		Date date = new Date();
		//Spring的copy方法，将相同字段的类copy到另一个类中
		BeanUtils.copyProperties(user, userDto);
		//设置userName
		userDto.setUserName(user.getLoginId());
		//设置更新时间及创建时间
		userDto.setCreateAt(date);
		userDto.setUpdateAt(date);
		//设置是否被删除
		userDto.setIsDeleted("f");
		//保存用户信息
		userService.saveUser(userDto);
		return CommonResponseType.create("注册成功");
	}
	
	/**获取验证码*/
	@RequestMapping("/verification_code")
	@ResponseBody
	public CommonResponseType verification_code(String phoneNumber) {
		Random random = new Random();
		int randomInt = random.nextInt(99999);
		randomInt += 10000;
		String otp = String.valueOf(randomInt);
		
		httpServletRequest.getSession().setAttribute(phoneNumber, otp);
		
		System.out.println("手机号为"+phoneNumber + "的验证码为:" + otp);
		
		return CommonResponseType.create(otp);
	}
	
	/**用户登陆*/
	@RequestMapping("/login_load")
	@ResponseBody
	public CommonResponseType login_load(User user) {
		
		UserDto userDto = new UserDto();
		//Spring的copy方法，将相同字段的类copy到另一个类中
		BeanUtils.copyProperties(user, userDto);
		UserDto resultUser = null;
		try {
			resultUser = userService.getUser(userDto);
			//判断返回用户是否为空
			if (resultUser == null) {
				throw new BusinessException(EmBusinessError.USER_NOT_EXCIT,"用户不存在");
			} else {
				if (!resultUser.getPassward().equals(user.getPassward())) {
					throw new BusinessException(EmBusinessError.USER_PASSWARD_ERROR,"密码不正确");
				}
			}
		} catch (BusinessException e) {
			Map<String, Object> map = new HashMap<>();
			map.put("errorCode", e.getErrorCode());
			map.put("errorMsg", e.getErrorMsg());
			return CommonResponseType.create(map, Result.FAIL.getStauts());
		}
		
		//将用户存入redis（实现session跨域）
		Jedis jedis = new Jedis("192.168.0.106",6379);
		System.out.println("连接成功");
		//查看服务是否运行
		System.out.println("服务正在运行: "+jedis.ping());
		jedis.append("currentUser", JSONUtils.toJSONString(resultUser));
		return CommonResponseType.create("登陆成功");
	}
}
