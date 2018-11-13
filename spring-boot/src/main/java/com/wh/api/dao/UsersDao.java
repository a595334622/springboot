package com.wh.api.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.wh.api.entity.UsersEntity;

/**
 * 用户
 * @author：王浩
 * @since：2018年08月02日 15时45分34秒 星期四 
 * @version:1.0
 */
@Repository
public interface UsersDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM users WHERE ID = :id")
	UsersEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param users
	 * @return
	 */
	int update(@Param("users") UsersEntity users);
	
	/**
	 * 插入数据
	 * @param users
	 */
	void insert(@Param("users") UsersEntity users);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param users
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(UsersEntity.class)
	public MiniDaoPage<UsersEntity> getAll(@Param("users") UsersEntity users,@Param("page")  int page,@Param("rows") int rows);
	
	/**
	 * 删除数据
	 * @param users
	 */
	@Sql("DELETE from users WHERE ID = :users.id")
	public void delete(@Param("users") UsersEntity users);
	
}

