package com.wh.config;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

/** 
 * 核心配置类
* @FileName Config.java
* @Description:TODO
* @author JackHisen(gu.weidong)
* @version V1.0
* @createtime 2018年1月21日 下午7:53:22 
*====================================================  
* 1. @ImportResource 	加载配置文件
* 2. @EnableJms 			JMS
* 3. @EnableDubboConfiguration  dubbo
*/
@Configuration
@EnableJms
@EnableDubboConfiguration
@ImportResource(value = {"classpath:config/spring-config.xml"})
public class CoreConfig {
	
	/**
	 * activemq 生产消费 
	* @Title: queue  
	* @param @return  参数说明 
	* @return Queue    返回类型 
	* @throws
	 */
	@Bean
    public Queue queue() {
        return new ActiveMQQueue("demo.queue");
    }

	/**
	 * activemq 发布订阅 
	* @Title: queue  
	* @param @return  参数说明 
	* @return Queue    返回类型 
	* @throws
	 */
	@Bean
    public JmsListenerContainerFactory<?> myJmsListenerContainerFactory(ConnectionFactory connectionFactory){
		SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		factory.setPubSubDomain(true);
		return factory;
	}
}
