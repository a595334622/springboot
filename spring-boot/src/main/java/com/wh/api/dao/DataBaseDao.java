package com.wh.api.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.wh.api.entity.DataBaseEntity;

/**
 *  数据库切换
 * @author：王浩
 * @since：2018年08月27日 19时25分27秒 星期一 
 * @version:1.0
 */
@Repository
public interface DataBaseDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM data_base WHERE ID = :id")
	DataBaseEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param dataBase
	 * @return
	 */
	int update(@Param("dataBase") DataBaseEntity dataBase);
	
	/**
	 * 插入数据
	 * @param dataBase
	 */
	void insert(@Param("dataBase") DataBaseEntity dataBase);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param dataBase
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(DataBaseEntity.class)
	public MiniDaoPage<DataBaseEntity> getAll(@Param("dataBase") DataBaseEntity dataBase,@Param("page")  int page,@Param("rows") int rows);
	
	/**
	 * 删除数据
	 * @param dataBase
	 */
	@Sql("DELETE from data_base WHERE ID = :dataBase.id")
	public void delete(@Param("dataBase") DataBaseEntity dataBase);
	/**
	 * 根据类型获取数据源
	* @Title: getByType 
	* @param type
	* @return DataBaseEntity
	 */
	@Sql("SELECT * FROM data_base WHERE type = :type")
	DataBaseEntity getByType(@Param("type") String type);
	
}

