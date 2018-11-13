package com.wh.api.jms;


import javax.annotation.Resource;
import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * activemq生产者
* @ClassName: Producer 
* @Description: activemq 生产者
* @author wh
* @date 2018年8月26日 下午4:34:17
 */
@Service
public class Producer {

	@Resource
	private JmsMessagingTemplate jmsMessagingTemplate;
	/**
	 * activemq 生产者
	* @Title: sendMsg  
	* @param   参数说明 
	* @return void    返回类型 
	* @throws
	 */
	public void sendMsg(String destinationName, String message) {
		Destination destination = new ActiveMQQueue(destinationName);
		jmsMessagingTemplate.convertAndSend(destination, message);
	}
	
}
