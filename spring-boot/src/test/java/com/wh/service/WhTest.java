package com.wh.service;

import javax.annotation.Resource;

import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wh.WhApplication;
import com.wh.aop.DynamicDataSourceAspect;
import com.wh.api.entity.UsersEntity;
import com.wh.api.jms.Producer;
import com.wh.api.jms.Publisher;
import com.wh.api.service.UsersService;
import com.wh.config.CacheConfig;
import com.wh.config.CoreConfig;
import com.wh.utils.JsonUtil;

/**
 * @ClassName: WhTest 
 * @Description: TODO 单元测试
 * @author: 59533
 * @date: 2018年8月17日 下午1:05:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest( classes = {WhApplication.class, CoreConfig.class, CacheConfig.class})
@SpringBootConfiguration
public class WhTest {

	/**
	 * kafka 测试
	 */
//	@Autowired
//	private KafkaSender kafkaSender;

	/**
	 * h2 测试
	 */
	@Test
	public void h2Test() {
		try {
			UsersEntity usersEntity = new UsersEntity();
			usersEntity.setId("2");
			usersEntity.setStatus(1);
			usersEntity.setUsername("123");
			usersEntity.setPassword("123");
			usersService.delete(usersEntity);
			UsersEntity users = usersService.get("2");
			System.err.println(JsonUtil.toJson(users));

			MiniDaoPage<UsersEntity> all = usersService.getAll(new UsersEntity(), 1, 5);
			System.err.println(all.getRows());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Resource
	private UsersService usersService;
	/**
	 * redis 测试
	 */
	@Test
	public void redisCacheTest() {
		try {
			int getInt = 5;
			for (int i = 0; i < getInt; i++) {
				UsersEntity usersEntity = usersService.get("FF71F0238FF043128E1BA8FFB5D5C906");
				System.err.println(JsonUtil.toJson(usersEntity));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Resource
	private Producer producer;
	@Resource
	private Publisher publisher;
	/**
	 * activemq 测试
	 */
	@Test
	public void activeMqQueueTest() {
		try {
			//消息生产消费
			int queue = 20;
			for (int i = 0; i < queue; i++) {
				producer.sendMsg("demo.queue", "产品" + i);
			}
			//消息发布订阅
			int topic = 20;
			for (int i = 0; i < topic; i++) {
				publisher.publish("demo.topic", "报纸" + i);
			}

			Thread.sleep(5000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 动态数据源 测试
	 */
	@Test
	public void dynamicDataSourceTest() {
		try {
			UsersEntity usersEntity = usersService.getForDynamicDataSource( DynamicDataSourceAspect.SPILT_DYNAMIC + "23123", "FF71F0238FF043128E1BA8FFB5D5C906");
			System.err.println(JsonUtil.toJson(usersEntity));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
