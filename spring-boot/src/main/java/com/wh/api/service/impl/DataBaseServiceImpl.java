package com.wh.api.service.impl;

import javax.annotation.Resource;

import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wh.api.dao.DataBaseDao;
import com.wh.api.entity.DataBaseEntity;
import com.wh.api.service.DataBaseService;

/**
 *  数据库列表 逻辑实现层
 * @author: 王浩
 * @since：2018年08月27日 19时25分27秒 星期一 
 * @version:1.0
 */

@Service("dataBaseService")
@Transactional(rollbackFor=Exception.class)
public class DataBaseServiceImpl implements DataBaseService {
	@Resource
	private DataBaseDao dataBaseDao;

	@Override
	public DataBaseEntity get(String id) {
		return dataBaseDao.get(id);
	}

	@Override
	public int update(DataBaseEntity dataBase) {
		return dataBaseDao.update(dataBase);
	}

	@Override
	public void insert(DataBaseEntity dataBase) {
		dataBaseDao.insert(dataBase);
		
	}

	@Override
	public MiniDaoPage<DataBaseEntity> getAll(DataBaseEntity dataBase, int page, int rows) {
		return dataBaseDao.getAll(dataBase, page, rows);
	}

	@Override
	public void delete(DataBaseEntity dataBase) {
		dataBaseDao.delete(dataBase);
		
	}

	@Override
	public DataBaseEntity getByType(String dbtype) {
		return dataBaseDao.getByType(dbtype);
	}
}
