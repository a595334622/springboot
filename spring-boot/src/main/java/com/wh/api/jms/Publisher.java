package com.wh.api.jms;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
/**
 * activemq 发布者
* @ClassName: Publisher 
* @Description: activemq 发布者
* @author wh
* @date 2018年8月26日 下午4:54:15
 */
@Service
public class Publisher {
	@Resource
	private JmsMessagingTemplate jmsMessagingTemplate;
	/**
	 * activemq 发布者
	* @Title: publish  
	* @param   参数说明 
	* @return void    返回类型 
	* @throws
	 */
	public void publish(String destinationName, String message) {
		Destination destination = new ActiveMQTopic(destinationName);
		jmsMessagingTemplate.convertAndSend(destination, message);
	}
}
