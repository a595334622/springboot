package com.wh.api.service;

import org.jeecgframework.minidao.pojo.MiniDaoPage;
import com.wh.api.entity.DataBaseEntity;

/**
 * 数据库列表逻辑层
 * @author: 王浩
 * @since：2018年08月27日 19时25分27秒 星期一 
 * @version:1.0
 */
public interface DataBaseService {
	/**
	 * 代码生成  根据id获取实体
	* @Title: get 
	* @Description: TODO 
	* @param id
	* @return DataBaseEntity
	* @author 王浩
	 */
	public DataBaseEntity get(String id);
	/**
	 * 代码生成  根据id更改实体
	* @Title: update 
	* @Description: TODO 
	* @param dataBase
	* @return int
	* @author 王浩
	 */
	public int update(DataBaseEntity dataBase);
	/**
	 * 代码生成  插入实体
	* @Title: insert 
	* @Description: TODO 
	* @param dataBase void
	* @author 王浩
	 */
	public void insert(DataBaseEntity dataBase);
	/**
	 * 代码生成 根据条件分页获取全部
	* @Title: getAll 
	* @Description: TODO 
	* @param dataBase
	* @param page
	* @param rows
	* @return MiniDaoPage<DataBaseEntity>
	* @author 王浩
	 */
	public MiniDaoPage<DataBaseEntity> getAll(DataBaseEntity dataBase,int page,int rows);
	/**
	 * 代码生成 根据实体id删除
	* @Title: delete 
	* @Description: TODO 
	* @param dataBase void
	* @author 王浩
	 */
	public void delete(DataBaseEntity dataBase);
	/**
	 * 根据类型查询
	* @Title: getByType 
	* @Description: TODO 
	* @param dbtype
	* @return DataBaseEntity
	* @author 59533
	* @date 2018年8月27日下午7:30:16
	 */
	public DataBaseEntity getByType(String dbtype);
	
}
