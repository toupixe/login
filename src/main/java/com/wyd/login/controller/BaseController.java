package com.wyd.login.controller;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.wyd.login.webutils.error.erroenum.EmBusinessError;
import com.wyd.login.webutils.exception.BusinessException;
import com.wyd.login.webutils.result.CommonResponseType;
import com.wyd.login.webutils.result.Result;

public class BaseController {
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Object exceptionHandler(HttpServletRequest request, Exception exception) {
		
		Map<String,Object> map = new HashMap<>();
		
		if(exception instanceof BusinessException) {
			BusinessException runtimeException = (BusinessException) exception;
			
			map.put("errorCode", runtimeException.getErrorCode());
			map.put("errorMsg", runtimeException.getErrorMsg());
		} else {
			map.put("errorCode", EmBusinessError.UNKNOW_ERROR.getErrorCode());
			map.put("errorMsg", EmBusinessError.UNKNOW_ERROR.getErrorMsg());
		}
		
		return CommonResponseType.create(map, Result.FAIL.getStauts());
	}
}

