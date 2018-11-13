package com.wh.api.service;

import org.jeecgframework.minidao.pojo.MiniDaoPage;
import com.wh.api.entity.UsersEntity;

/**
 * 用户逻辑层
 * @author: 王浩
 * @since：2018年08月02日 15时45分34秒 星期四 
 * @version:1.0
 */
public interface UsersService {
	/**
	 * 代码生成  根据id获取实体
	* @Title: get 
	* @Description: TODO 
	* @param id
	* @return UsersEntity
	* @author 59533
	* @date 2018年8月17日上午11:51:27
	 */
	public UsersEntity get(String id);
	/**
	 * 代码生成  根据id更改实体
	* @Title: update 
	* @Description: TODO 
	* @param users
	* @return int
	* @author 59533
	* @date 2018年8月17日上午11:52:07
	 */
	public int update(UsersEntity users);

	/**
	 * 代码生成  插入实体
	* @Title: insert 
	* @Description: TODO 
	* @param users void
	* @author 59533
	* @date 2018年8月17日上午11:52:21
	 */
	public void insert(UsersEntity users);
	/**
	 * 代码生成 获取全部
	* @Title: getAll 
	* @Description: TODO 
	* @param users
	* @param page
	* @param rows
	* @return MiniDaoPage<UsersEntity>
	* @author 59533
	* @date 2018年8月17日上午11:52:33
	 */
	public MiniDaoPage<UsersEntity> getAll(UsersEntity users,int page,int rows);
	/**
	 * 代码生成 根据实体id删除
	* @Title: delete 
	* @Description: TODO 
	* @param users void
	* @author 59533
	* @date 2018年8月17日上午11:52:42
	 */
	public void delete(UsersEntity users);
	/**
	 * 动态更换数据源测试
	* @Title: getForDynamicDataSource 
	* @Description: TODO 
	* @param dbName 数据源名称 需放置第一个且带有标志位
	* @param id
	* @return UsersEntity
	* @author 59533
	* @date 2018年8月27日下午10:46:33
	 */
	public UsersEntity getForDynamicDataSource(String dbName, String id);
}
