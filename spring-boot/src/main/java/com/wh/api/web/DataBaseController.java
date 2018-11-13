package com.wh.api.web;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.velocity.VelocityContext;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.page.SystemTools;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.jeecgframework.p3.core.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.wh.api.entity.DataBaseEntity;
import com.wh.api.service.DataBaseService;

 /**
 * 数据库切换列表Controller层
 * @author: 王浩
 * @since：2018年08月27日 19时25分27秒 星期一 
 * @version:1.0
 */
@Controller
@RequestMapping("/wh/dataBase")
public class DataBaseController extends BaseController{
  	@Autowired
  	private DataBaseService dataBaseService;
  
  	private Logger log = LoggerFactory.getLogger(DataBaseController.class);
	/**
	  * 列表页面
	  * @return
	  */
	@RequestMapping(params = "list",method = {RequestMethod.GET,RequestMethod.POST})
	public void list(@ModelAttribute DataBaseEntity query,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
			try {
			 	//分页数据
				MiniDaoPage<DataBaseEntity> list =  dataBaseService.getAll(query,pageNo,pageSize);
				VelocityContext velocityContext = new VelocityContext();
				velocityContext.put("dataBase",query);
				velocityContext.put("pageInfos",SystemTools.convertPaginatedList(list));
				String viewName = "wh/api/dataBase-list.vm";
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
	public void dataBaseDetail(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request)throws Exception{
			VelocityContext velocityContext = new VelocityContext();
			String viewName = "wh/api/dataBase-detail.vm";
			DataBaseEntity dataBase = dataBaseService.get(id);
			velocityContext.put("dataBase",dataBase);
			ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping(params = "toAdd",method ={RequestMethod.GET, RequestMethod.POST})
	public void toAddDialog(HttpServletRequest request,HttpServletResponse response)throws Exception{
		 VelocityContext velocityContext = new VelocityContext();
		 String viewName = "wh/api/dataBase-add.vm";
		 ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 保存信息
	 * @return
	 */
	@RequestMapping(params = "doAdd",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doAdd(@ModelAttribute DataBaseEntity dataBase){
		AjaxJson j = new AjaxJson();
		try {
		    String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		    dataBase.setId(randomSeed);
			dataBaseService.insert(dataBase);
			j.setMsg("保存成功");
		} catch (Exception e) {
		    log.info("数据库保存失败", e);
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
			 DataBaseEntity dataBase = dataBaseService.get(id);
			 velocityContext.put("dataBase",dataBase);
			 String viewName = "wh/api/dataBase-edit.vm";
			 ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping(params = "doEdit",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute DataBaseEntity dataBase){
		AjaxJson j = new AjaxJson();
		try {
			dataBaseService.update(dataBase);
			j.setMsg("编辑成功");
		} catch (Exception e) {
		    log.info("数据库编辑失败", e);
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
			    DataBaseEntity dataBase = new DataBaseEntity();
				dataBase.setId(id);
				dataBaseService.delete(dataBase);
				j.setMsg("删除成功");
			} catch (Exception e) {
			    log.info("数据库删除失败", e);
				j.setSuccess(false);
				j.setMsg("删除失败");
			}
			return j;
	}


}

