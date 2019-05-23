package com.wyd.login.webutils.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.wyd.login.dto.LoadingDto;
import com.wyd.login.service.LoadingService;
import com.wyd.login.webutils.utils.CheckBrowserUtils;

import nl.bitwalker.useragentutils.Browser;
import nl.bitwalker.useragentutils.OperatingSystem;
import nl.bitwalker.useragentutils.UserAgent;


@Component
public class ActionInterceprot implements HandlerInterceptor {

	@Autowired
	private CheckBrowserUtils checkBrowserUtils;
	
	@Autowired
	private LoadingService loadingService;
	
	private String SESSION_ID = "";
	
	
	/**
     * 进入controller层之前拦截请求
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        System.out.println("---------------------开始进入请求地址拦截----------------------------");
        String sessionId = httpServletRequest.getRequestedSessionId();
        //如果使同一个用户登陆
        if (sessionId != null && sessionId.equals(SESSION_ID)) {
        	return true;
        }
        String userAgentStr = httpServletRequest.getHeader("USER-AGENT").toLowerCase();//USER-AGENT字段全部转换成小写
        LoadingDto loadingDto = new LoadingDto();
        loadingDto.setTime(new Date());
		//转成UserAgent对象
		UserAgent userAgent = UserAgent.parseUserAgentString(userAgentStr); 
		//获取浏览器信息
		Browser browser = userAgent.getBrowser();  
		//获取系统信息
		OperatingSystem os = userAgent.getOperatingSystem();
		
		//url
		loadingDto.setUrl(httpServletRequest.getRequestURL().toString());
		String deviceType = "";
		String isComputor = "";
		if (userAgent != null) {
			if (checkBrowserUtils.browserList.contains(userAgent)) {
				//是移动端
				deviceType = "移动端";
				isComputor = "1";
			} else {
				//PC端
				deviceType = "PC端";
				isComputor = "2";
			}
		}
		//系统名称*浏览器名称
		loadingDto.setDevice(deviceType + "*" + os.getName() + "*" + browser.getName());
		loadingDto.setIsComputor(isComputor);
		//将访问记录保存至数据库
		loadingService.insertLoadingCount(loadingDto);
		SESSION_ID = sessionId;
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    	//System.out.println("--------------处理请求完成后视图渲染之前的处理操作---------------");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    	//System.out.println("---------------视图渲染之后的操作-------------------------0");
    }
}
