package com.wh.api.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.VelocityContext;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.p3.core.page.SystemTools;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.jeecgframework.p3.core.web.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wh.api.service.MonitorService;
import com.wh.core.monitor.MonitorEntity;

 /**
 * 日志监控 Controller层
 * @author: 王浩
 * @since：2018年09月05日 20时17分34秒 星期三 
 * @version:1.0
 */
@Controller
@RequestMapping("/wh/monitor")
public class MonitorController extends BaseController{
  	@Autowired
  	private MonitorService monitorService;
  
  	private Logger log = LoggerFactory.getLogger(MonitorController.class);
	/**
	  * 列表页面
	  * @return
	  */
	@RequestMapping(params = "list",method = {RequestMethod.GET,RequestMethod.POST})
	public void list(@ModelAttribute MonitorEntity query,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
			try {
			 	//分页数据
				MiniDaoPage<MonitorEntity> list =  monitorService.getAll(query,pageNo,pageSize);
				VelocityContext velocityContext = new VelocityContext();
				velocityContext.put("monitor",query);
				velocityContext.put("pageInfos",SystemTools.convertPaginatedList(list));
				String viewName = "wh/api/monitor-list.vm";
				ViewVelocity.view(request,response,viewName,velocityContext);
			} catch (Exception e) {
				log.info("数据库列表", e);
			}
	}

	 /**
	  * 详情
	  * @return
	  */
	@RequestMapping(params="toDetail",method = RequestMethod.GET)
	public void monitorDetail(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request)throws Exception{
		try {
			VelocityContext velocityContext = new VelocityContext();
			String viewName = "wh/api/monitor-detail.vm";
			MonitorEntity monitor = monitorService.get(id);
			velocityContext.put("monitor",monitor);
			MonitorEntity query = new MonitorEntity();
			query.setToken(monitor.getToken());
			MiniDaoPage<MonitorEntity> list =  monitorService.getAll(query, 1, 100);
			velocityContext.put("pageInfos",SystemTools.convertPaginatedList(list));
			ViewVelocity.view(request,response,viewName,velocityContext);
		} catch (Exception e) {
			log.info("数据库详情", e);
		}
	}

}

