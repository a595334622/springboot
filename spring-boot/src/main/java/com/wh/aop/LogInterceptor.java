package com.wh.aop;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 日志添加唯一TOKEN
 * @ClassName: LogInterceptor 
 * @Description: TODO 日志添加唯一标志位 需要配置
 * @author: 59533
 * @date: 2018年9月6日 下午2:03:44
 */
public class LogInterceptor extends HandlerInterceptorAdapter {
	/**
	 * 日志TOKEN
	 */
	public static final String MONITOR_TOKEN = "MONITOR_TOKEN";
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String token = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		MDC.put(MONITOR_TOKEN, token);
		return true;
	}
}