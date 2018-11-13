package com.wh.api.web;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.VelocityContext;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.page.SystemTools;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wh.api.entity.UsersEntity;
import com.wh.api.service.UsersService;
import com.wh.core.monitor.MonitorEntity;
import com.wh.core.monitor.MonitorEnum;
import com.wh.utils.JsonUtil;

/**
 * 用户列表 Controller层
 * @author: 王浩
 * @since：2018年08月02日 15时45分34秒 星期四 
 * @version:1.0
 */
@Controller
@RequestMapping("/wh/users")
public class UsersController{
	@Autowired
	private UsersService usersService;

	private final Logger LOG = LoggerFactory.getLogger(UsersController.class);
	private final Logger MONITORLOG = LoggerFactory.getLogger("monitor");
	/**
	 * 列表页面
	 * @return
	 */
	@RequestMapping(params = "list",method = {RequestMethod.GET,RequestMethod.POST})
	public void list(@ModelAttribute UsersEntity query,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
		try {
			MONITORLOG.info(JsonUtil.toJson(new MonitorEntity(MonitorEnum.infoRequest, JsonUtil.toJson(query), "用户列表", null)));

			//分页数据
			MiniDaoPage<UsersEntity> list =  usersService.getAll(query,pageNo,pageSize);
			VelocityContext velocityContext = new VelocityContext();
			velocityContext.put("users",query);
			velocityContext.put("pageInfos",SystemTools.convertPaginatedList(list));
			String viewName = "wh/api/users-list.vm";
			ViewVelocity.view(request,response,viewName,velocityContext);
		} catch (Exception e) {
			LOG.error("用户列表", e);
			MONITORLOG.info(JsonUtil.toJson(new MonitorEntity(MonitorEnum.error, JsonUtil.toJson(query), "用户列表", e)));
		}
	}

	/**
	 * 详情
	 * @return
	 */
	@RequestMapping(params="toDetail",method = RequestMethod.GET)
	public void usersDetail(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request)throws Exception{
		try {
			VelocityContext velocityContext = new VelocityContext();
			String viewName = "wh/api/users-detail.vm";
			UsersEntity users = usersService.get(id);
			velocityContext.put("users",users);
			ViewVelocity.view(request,response,viewName,velocityContext);
		} catch (Exception e) {
			LOG.error("用户详情", e);
		}
	}

	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping(params = "toAdd",method ={RequestMethod.GET, RequestMethod.POST})
	public void toAddDialog(HttpServletRequest request,HttpServletResponse response)throws Exception{
		try {
			VelocityContext velocityContext = new VelocityContext();
			String viewName = "wh/api/users-add.vm";
			ViewVelocity.view(request,response,viewName,velocityContext);
		} catch (Exception e) {
			LOG.error("用户添加", e);
		}
	}

	/**
	 * 保存信息
	 * @return
	 */
	@RequestMapping(params = "doAdd",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doAdd(@ModelAttribute UsersEntity users){
		AjaxJson j = new AjaxJson();
		try {
			String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
			users.setId(randomSeed);
			usersService.insert(users);
			j.setMsg("保存成功");
		} catch (Exception e) {
			LOG.error("用户保存失败", e);
			j.setSuccess(false);
			j.setMsg("保存失败");
		}
		return j;
	}

	/**
	 * 跳转到编辑页面
	 * @return
	 */
	@RequestMapping(params="toEdit",method = RequestMethod.GET)
	public void toEdit(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request) throws Exception{
		VelocityContext velocityContext = new VelocityContext();
		UsersEntity users = usersService.get(id);
		velocityContext.put("users",users);
		String viewName = "wh/api/users-edit.vm";
		ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping(params = "doEdit",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute UsersEntity users){
		AjaxJson j = new AjaxJson();
		try {
			usersService.update(users);
			j.setMsg("编辑成功");
		} catch (Exception e) {
			LOG.error("用户编辑失败", e);
			j.setSuccess(false);
			j.setMsg("编辑失败");
		}
		return j;
	}


	/**
	 * 删除
	 * @return
	 */
	@RequestMapping(params="doDelete",method = RequestMethod.GET)
	@ResponseBody
	public AjaxJson doDelete(@RequestParam(required = true, value = "id" ) String id){
		AjaxJson j = new AjaxJson();
		try {
			UsersEntity users = new UsersEntity();
			users.setId(id);
			usersService.delete(users);
			j.setMsg("删除成功");
		} catch (Exception e) {
			LOG.error("用户删除失败", e);
			j.setSuccess(false);
			j.setMsg("删除失败");
		}
		return j;
	}


}

