package com.wyd.login.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.wyd.login.webutils.interceptor.ActionInterceprot;

@Configuration
@EnableRedisHttpSession()
public class WebInterceptorConfig implements WebMvcConfigurer{
	@Autowired
    private ActionInterceprot actionInterceprot;
 
    /**
     * 重写添加拦截器方法并添加配置拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(actionInterceprot).addPathPatterns("/**")   //拦截哪些路径("/**":代表拦截所有路径);
               .excludePathPatterns("/login", "/logout","/error","docs.html"); //不拦截哪些路径;
    }

}
