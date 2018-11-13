package com.wh.core.kafka;

/**
 * kafka消费者
* @ClassName: KafkaConsumer 
* @author wh
* @date 2018年8月29日 下午9:00:00
 */
public class KafkaConsumer {

	private final String KAFKA_TOPIC = "test";
	
	/**
	 * 
	 * kafka消费者
	* @Title: consumer  
	* @param @param message  参数说明 
	* @return void    返回类型 
	* @throws
	* ==================================
	* @KafkaListener(topics = {KAFKA_TOPIC})
	 */
	public void consumer(String message){
		
		System.err.println("接收到 " + message);
	}
}
