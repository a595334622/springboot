package com.wh.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wh.core.datasourse.DynamicDataSource;
/**
 * 动态数据源配置类
 * @ClassName: DynamicDataSourceConfiguration 
 * @Description: 动态数据源 
 * @author wh
 * @date 2018年8月27日 下午6:43:08
 */
@Configuration
public class DataSourceConfig {
	/**
	 *  初始化默认数据库 
	* @Title: masterDataSource 
	* @return DataSource
	* @author 59533
	* @date 2018年9月11日上午9:42:21
	 */
	@Bean(name = "masterDataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource masterDataSource(){
		DataSource dataSource = DataSourceBuilder.create().build();
		return dataSource;
	}
	
	 /**
      *  实例化spring数据库控制
     * @return
     */
    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源
        dynamicDataSource.setMasterDataSource(masterDataSource());
        return dynamicDataSource;
    }
}
