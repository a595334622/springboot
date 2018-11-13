package com.wh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 项目启动类
 * @ClassName: WhApplication 
 * @author: wh
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class WhApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhApplication.class,args);
	}

}
