package ${servicePackage};

import org.jeecgframework.minidao.pojo.MiniDaoPage;
import ${domainPackage}.${className}Entity;

/**
 * ${codeName} 逻辑层
 * @author: ${author}
 * @since：${nowDate}
 * @version:1.0
 */
public interface ${className}Service {
	/**
	 * 代码生成  根据id获取实体
	* @Title: get 
	* @Description: TODO 
	* @param id
	* @return ${className}Entity
	* @author ${author}
	 */
	public ${className}Entity get(String id);
	/**
	 * 代码生成  根据id更改实体
	* @Title: update 
	* @Description: TODO 
	* @param ${lowerName}
	* @return int
	* @author ${author}
	 */
	public int update(${className}Entity ${lowerName});
	/**
	 * 代码生成  插入实体
	* @Title: insert 
	* @Description: TODO 
	* @param ${lowerName} void
	* @author ${author}
	 */
	public void insert(${className}Entity ${lowerName});
	/**
	 * 代码生成 根据条件分页获取全部
	* @Title: getAll 
	* @Description: TODO 
	* @param ${lowerName}
	* @param page
	* @param rows
	* @return MiniDaoPage<${className}Entity>
	* @author ${author}
	 */
	public MiniDaoPage<${className}Entity> getAll(${className}Entity ${lowerName},int page,int rows);
	/**
	 * 代码生成 根据实体id删除
	* @Title: delete 
	* @Description: TODO 
	* @param ${lowerName} void
	* @author ${author}
	 */
	public void delete(${className}Entity ${lowerName});
	
}
