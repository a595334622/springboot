package com.wh.core.monitor;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.slf4j.MDC;

import com.wh.aop.LogInterceptor;
import com.wh.utils.CoreUtils;

/**
 * 数据库监控实体
 * @author: 王浩
 * @since：2018年09月05日 20时17分34秒 星期三 
 * @version:1.0
 */
public class MonitorEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	/**
	 *创建时间
	 */
	private String createTime;

	public MonitorEntity() {
		super();
	}

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
	/**
	 * @param 日志类型 type ：infoRequest infoResponse error 
	 * @param parameters 详细参数
	 * @param parametersType 方法解释
	 * @param token 唯一id
	 * @param e	错误
	 */
	public MonitorEntity(MonitorEnum type, String parameters,
			String parametersType, Exception e) {
		super();
		this.id = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		this.tProject = "spring-boot";
		this.type = type.toString();
		this.location = defaultTag();
		this.parameters = parameters;
		this.parametersType = parametersType;
		String monitorToken = MDC.get(LogInterceptor.MONITOR_TOKEN);
		if (monitorToken != null) {
			this.token = monitorToken;
		}
		if (e != null) {
			this.error = e.getMessage();
			this.errorInfo = CoreUtils.eToString(e);
		}
		this.createTime = sdf.format(new Date());
	}
	public String getId() {

	public String gettProject() {
		return tProject;
	}

	public void settProject(String tProject) {
		this.tProject = tProject;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	private static String defaultTag() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		StackTraceElement log = stackTrace[1];
		String tag = null;
		for (int i = 1; i < stackTrace.length; i++) {
			StackTraceElement e = stackTrace[i];
			if (!e.getClassName().equals(log.getClassName())) {
				tag = e.getClassName() + "." + e.getMethodName();
				break;
			}
		}
		if (tag == null) {
			tag = log.getClassName() + "." + log.getMethodName();

		}
		return tag;
	}

}
