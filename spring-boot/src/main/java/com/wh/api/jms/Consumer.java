package com.wh.api.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
/**
 * activemq消费者
* @ClassName: Consumer 
* @Description: activemq 消费者
* @author wh
* @date 2018年8月26日 下午4:41:29
*/
@Service
public class Consumer {
	/**
	 * activemq 测试消费者A
	* @Title: receiveQueueA 
	* @param text void
	* @author 59533
	* @date 2018年9月11日上午9:18:52
	 */
    @JmsListener(destination = "demo.queue")
    public void receiveQueueA(String text) {
        System.out.println("A  ==>" + text);
    }
    /**
     * activemq 测试消费者B
    * @Title: receiveQueueB 
    * @param text void
    * @author 59533
    * @date 2018年9月11日上午9:19:36
     */
    @JmsListener(destination = "demo.queue")
    public void receiveQueueB(String text) {
        System.out.println("B  ==>" + text);
    }
}
