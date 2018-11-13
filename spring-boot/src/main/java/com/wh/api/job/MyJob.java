package com.wh.api.job;

import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.wh.api.service.UsersService;
/**
 * 测试定时器
 * @ClassName: MyJob 
 * @Description: TODO
 * @author: wh
 * @date: 2018年8月17日 上午11:45:16
 */
@Component
public class MyJob{
	
	@Resource
	private UsersService usersService;
	
	private Logger log = LoggerFactory.getLogger(MyJob.class);
	/**
	 * 测试定时JOB
	* @Title: contractSendMail 
	* @author 59533
	* @date 2018年9月11日上午9:21:02
	 */
	@Scheduled(fixedRate=1000*1000) 
	public void contractSendMail(){
		String token = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		MDC.put("THREAD_ID", token);
		log.info("------------------test--------------");
		log.error("-----------------error--------------");
		
	}

}
