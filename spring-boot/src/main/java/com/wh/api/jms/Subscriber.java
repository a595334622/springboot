package com.wh.api.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
/**
 * activemq 订阅者
* @ClassName: Subscriber 
* @Description: activemq 订阅者
* @author wh
* @date 2018年8月26日 下午4:57:03
*/
@Service
public class Subscriber {
	/**
	 * activemq 测试订阅者A
	* @Title: subscribeA 
	* @param text void
	* @author 59533
	* @date 2018年9月11日上午9:20:09
	 */
	@JmsListener(destination = "demo.topic", containerFactory	= "myJmsListenerContainerFactory")
	public void subscribeA(String text) {
		System.err.println("订阅A  " + text);
	}
	/**
	 * activemq 测试订阅者B
	* @Title: subscribeB 
	* @param text void
	* @author 59533
	* @date 2018年9月11日上午9:20:28
	 */
	@JmsListener(destination = "demo.topic", containerFactory	= "myJmsListenerContainerFactory")
	public void subscribeB(String text) {
		System.err.println("订阅B  " + text);
	}
}
