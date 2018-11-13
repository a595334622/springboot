package com.wh.core.datasourse;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.wh.api.dao.DataBaseDao;
import com.wh.api.entity.DataBaseEntity;


/**
 * 动态数据源调度
* @ClassName: DynamicDataSource 
* @author wh 
* @date 2018年8月27日 下午6:54:45
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
	
	/** 存在循环引用 ，启动时有空指针错误 ，可以正常使用 */
	@Resource
	private DataBaseDao dataBaseDao;
    
    /** 默认数据源 */
    protected DataSource masterDataSource;
    /** 保存动态创建的数据源  */
    private static final Map<Object, Object> TARGE_DATA_SOURCE = new HashMap<>();
    
    private final String DEFAULT_DATASOURCE = "dataSource";
    
    private Logger log = LoggerFactory.getLogger(DynamicDataSource.class);
    
    @Override
    protected DataSource determineTargetDataSource() {
    	try {
	        String dataSourceName = determineCurrentLookupKey();
	        if(DEFAULT_DATASOURCE.equals(dataSourceName)) {
	            return masterDataSource;
	        }
	        
	        DataSource dataSource = (DataSource) TARGE_DATA_SOURCE.get(dataSourceName);
	        if(null == dataSource) {
	            dataSource = this.selectDataSource(dataSourceName);
	        }
	        return dataSource;
    	} catch (Exception e) {
    		log.error("动态数据源报错", e);
		}
    	return null;
    }
    
    @Override
    protected String determineCurrentLookupKey() {
        String dataSourceName = DynamicDataSourceContextHolder.getDataSourceType();
        if (dataSourceName == null || dataSourceName == DEFAULT_DATASOURCE) {
            // 默认的数据源名字
            dataSourceName = "dataSource";
        }else {
			log.info("更换数据库  ==>" + dataSourceName);
		}
        return dataSourceName;
    }

    public void addTargetDataSource(String key, BasicDataSource dataSource) {
        DynamicDataSource.TARGE_DATA_SOURCE.put(key, dataSource);
    }

    
    /**
     * 	该方法为同步方法，防止并发创建两个相同的数据库
     * 	使用双检锁的方式，防止并发
     * @param dbType
     * @return
     * @throws Exception 
     */
    private synchronized DataSource selectDataSource(String dbType) throws Exception {
        DataSource obj = (DataSource)DynamicDataSource.TARGE_DATA_SOURCE.get(dbType);
        if (null != obj) {
            return obj;
        } 
        BasicDataSource dataSource = this.getDataSource(dbType);
        if (null != dataSource) {
            this.setDataSource(dbType, dataSource);
            return dataSource;
        }else {
        	throw new Exception("创建" + dbType +"数据库失败!");
        }
    }
    
    /**
     * 查询对应数据库的信息
     * @param dbtype
     * @return
     * @throws Exception 
     */
    private BasicDataSource getDataSource(String dbtype) throws Exception {
    	
    	log.info("创建数据源  ==>" + dbtype);
    	
        String oriType = DynamicDataSourceContextHolder.getDataSourceType();
        // 先切换回主库
        DynamicDataSourceContextHolder.setDataSourceType("dataSource");
        
        DataBaseEntity dataBase = dataBaseDao.getByType(dbtype);
        
        if (dataBase == null) {
        	throw new Exception("创建" + dbtype +"数据库失败!");
		}
        
       // 切换回目标库
        DynamicDataSourceContextHolder.setDataSourceType(oriType);

        BasicDataSource dataSource = createDataSource(dataBase.getDriver(), dataBase.getUrl(), dataBase.getUsername(), dataBase.getPassword());
        return dataSource;
    }
    
    /**
     * 创建数据源
    * @Title: createDataSource 
    * @Description: TODO 
    * @param driverClassName
    * @param url
    * @param username
    * @param password
    * @return BasicDataSource
     */
    private BasicDataSource createDataSource(String driverClassName, String url,
            String username, String password) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setTestWhileIdle(true);
        
        dataSource.setInitialSize(2);
        dataSource.setMaxActive(10);
        dataSource.setMinIdle(2);
        dataSource.setMaxIdle(5);
        
        return dataSource;
    }

    public void setDataSource(String type, BasicDataSource dataSource) {
        this.addTargetDataSource(type, dataSource);
        DynamicDataSourceContextHolder.setDataSourceType(type);
    }

    @Override
    public void afterPropertiesSet() {
    }

    public DataSource getMasterDataSource() {
        return masterDataSource;
    }

    public void setMasterDataSource(DataSource dataSource) {
        this.masterDataSource = dataSource;
    }
    
    
}
