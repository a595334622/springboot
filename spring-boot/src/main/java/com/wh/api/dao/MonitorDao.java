package com.wh.api.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.wh.core.monitor.MonitorEntity;

/**
 * 日志监控
 * @author：王浩
 * @since：2018年09月05日 20时17分34秒 星期三 
 * @version:1.0
 */
@Repository
public interface MonitorDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM monitor WHERE ID = :id")
	MonitorEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param monitor
	 * @return
	 */
	int update(@Param("monitor") MonitorEntity monitor);
	
	/**
	 * 插入数据
	 * @param monitor
	 */
	void insert(@Param("monitor") MonitorEntity monitor);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param monitor
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(MonitorEntity.class)
	public MiniDaoPage<MonitorEntity> getAll(@Param("monitor") MonitorEntity monitor,@Param("page")  int page,@Param("rows") int rows);
	
	/**
	 * 删除数据
	 * @param monitor
	 */
	@Sql("DELETE from monitor WHERE ID = :monitor.id")
	public void delete(@Param("monitor") MonitorEntity monitor);
	
}

