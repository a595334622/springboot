package com.wh.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 主要工具类
 * @ClassName: CoreUtils 
 * @Description: TODO 主要工具类
 * @author: 59533
 * @date: 2018年9月5日 下午5:06:35
 */
public class CoreUtils {
	/**
	 * Exception转String
	* @Title: eToString 
	* @param e 错误
	* @return String
	* @author 59533
	* @date 2018年9月11日上午9:15:39
	 */
	public static String eToString(Exception e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		return sw.toString();
	}
}
