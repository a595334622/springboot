package com.wh.api.service.impl;

import org.springframework.stereotype.Service;

import com.jeecg.core.biz.mutiLang.service.P3MutiLangServiceI;
/**
 * p3逻辑实现层
 * @ClassName: P3MutiLangServiceImpl 
 * @Description: TODO
 * @author: 59533
 * @date: 2018年8月17日 上午11:45:59
 */
@Service("p3MutiLangService")
public class P3MutiLangServiceImpl
implements P3MutiLangServiceI
{
	@Override
	public String getLang(String langKey)
	{
		if (checkIsChinese(langKey)) {
			return langKey;
		}
		return langKey;
	}

	public static void main(String[] args)
	{
		checkIsChinese("please.select.department");
	}

	private static boolean checkIsChinese(String str)
	{
		if (str.getBytes().length == str.length()) {
			return false;
		}
		return true;
	}
}