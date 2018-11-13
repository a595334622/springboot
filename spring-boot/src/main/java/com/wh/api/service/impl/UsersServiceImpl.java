package com.wh.api.service.impl;

import javax.annotation.Resource;

import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wh.api.dao.UsersDao;
import com.wh.api.entity.UsersEntity;
import com.wh.api.service.UsersService;
import com.wh.core.monitor.MonitorEntity;
import com.wh.core.monitor.MonitorEnum;
import com.wh.utils.JsonUtil;

/**
 *  用户逻辑实现
 * @author: 王浩
 * @since：2018年08月02日 15时45分34秒 星期四 
 * @version:1.0
 */

@Service("usersService")
@Transactional(rollbackFor=Exception.class)
public class UsersServiceImpl implements UsersService {
	@Resource
	private UsersDao usersDao;

	private final Logger MONITORLOG = LoggerFactory.getLogger("monitor");
	/**
	 *   添加缓存
	 */
	@Override
	@Cacheable(value="testredis", key="'user_'+#id")
	public UsersEntity get(String id) {
		return usersDao.get(id);
	}

	@Override
	public int update(UsersEntity users) {
		return usersDao.update(users);
	}

	@Override
	public void insert(UsersEntity users) {
		usersDao.insert(users);
		
	}

	@Override
	public MiniDaoPage<UsersEntity> getAll(UsersEntity users, int page, int rows) {
		MONITORLOG.info(JsonUtil.toJson(new MonitorEntity(MonitorEnum.infoRequest, JsonUtil.toJson(users), "用户列表", null)));
		int i = 1/0;
		return usersDao.getAll(users, page, rows);
	}
	/**
	 *   删除缓存
	 */
	@Override
	@CacheEvict(value="testredis", key="'users_'+#id",condition="#id!=1")
	public void delete(UsersEntity users) {
		usersDao.delete(users);
		
	}

	@Override
	public UsersEntity getForDynamicDataSource(String dbName, String id) {
		return usersDao.get(id);
	}
}
