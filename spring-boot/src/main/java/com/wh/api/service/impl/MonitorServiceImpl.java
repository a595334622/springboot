package com.wh.api.service.impl;

import javax.annotation.Resource;

import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wh.api.dao.MonitorDao;
import com.wh.core.monitor.MonitorEntity;
import com.wh.api.service.MonitorService;

/**
 * 日志监控逻辑实现层
 * @author: 王浩
 * @since：2018年09月05日 20时17分34秒 星期三 
 * @version:1.0
 */

@Service("monitorService")
@Transactional(rollbackFor=Exception.class)
public class MonitorServiceImpl implements MonitorService {
	@Resource
	private MonitorDao monitorDao;

	@Override
	public MonitorEntity get(String id) {
		return monitorDao.get(id);
	}

	@Override
	public int update(MonitorEntity monitor) {
		return monitorDao.update(monitor);
	}

	@Override
	public void insert(MonitorEntity monitor) {
		monitorDao.insert(monitor);
		
	}

	@Override
	public MiniDaoPage<MonitorEntity> getAll(MonitorEntity monitor, int page, int rows) {
		return monitorDao.getAll(monitor, page, rows);
	}

	@Override
	public void delete(MonitorEntity monitor) {
		monitorDao.delete(monitor);
		
	}
}
