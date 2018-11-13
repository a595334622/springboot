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
	/**	 *id	 */	private String id;	/**	 *项目	 */	private String tProject;	/**	 *状态	 */	private String type;	/**	 *位置	 */	private String location;	/**	 *参数	 */	private String parameters;	/**	 *参数种类	 */	private String parametersType;	/**	 *token	 */	private String token;	/**	 *错误	 */	private String error;	/**	 *详细错误	 */	private String errorInfo;
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
	public String getId() {		return this.id;	}	public void setId(String id) {		this.id=id;	}	public String getType() {		return this.type;	}	public void setType(String type) {		this.type=type;	}	public String getLocation() {		return this.location;	}	public void setLocation(String location) {		this.location=location;	}	public String getParameters() {		return this.parameters;	}	public void setParameters(String parameters) {		this.parameters=parameters;	}	public String getParametersType() {		return this.parametersType;	}	public void setParametersType(String parametersType) {		this.parametersType=parametersType;	}	public String getToken() {		return this.token;	}	public void setToken(String token) {		this.token=token;	}	public String getError() {		return this.error;	}	public void setError(String error) {		this.error=error;	}	public String getErrorInfo() {		return this.errorInfo;	}	public void setErrorInfo(String errorInfo) {		this.errorInfo=errorInfo;	}

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

