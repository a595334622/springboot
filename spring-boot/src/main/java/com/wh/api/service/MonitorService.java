package com.wh.api.service;

import org.jeecgframework.minidao.pojo.MiniDaoPage;
import com.wh.core.monitor.MonitorEntity;

/**
 * 日志监控列表逻辑层
 * @author: 王浩
 * @since：2018年09月05日 20时17分34秒 星期三 
 * @version:1.0
 */
public interface MonitorService {
	/**
	 * 代码生成  根据id获取实体
	* @Title: get 
	* @Description: TODO 
	* @param id
	* @return MonitorEntity
	* @author 王浩
	 */
	public MonitorEntity get(String id);
	/**
	 * 代码生成  根据id更改实体
	* @Title: update 
	* @Description: TODO 
	* @param monitor
	* @return int
	* @author 王浩
	 */
	public int update(MonitorEntity monitor);
	/**
	 * 代码生成  插入实体
	* @Title: insert 
	* @Description: TODO 
	* @param monitor void
	* @author 王浩
	 */
	public void insert(MonitorEntity monitor);
	/**
	 * 代码生成 根据条件分页获取全部
	* @Title: getAll 
	* @Description: TODO 
	* @param monitor
	* @param page
	* @param rows
	* @return MiniDaoPage<MonitorEntity>
	* @author 王浩
	 */
	public MiniDaoPage<MonitorEntity> getAll(MonitorEntity monitor,int page,int rows);
	/**
	 * 代码生成 根据实体id删除
	* @Title: delete 
	* @Description: TODO 
	* @param monitor void
	* @author 王浩
	 */
	public void delete(MonitorEntity monitor);
	
}
