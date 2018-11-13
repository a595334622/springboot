package ${serviceImplPackage};

import javax.annotation.Resource;

import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${daoPackage}.${className}Dao;
import ${domainPackage}.${className}Entity;
import ${servicePackage}.${className}Service;

/**
 * ${codeName} 逻辑实现层
 * @author: ${author}
 * @since：${nowDate}
 * @version:1.0
 */

@Service("${lowerName}Service")
@Transactional(rollbackFor=Exception.class)
public class ${className}ServiceImpl implements ${className}Service {
	@Resource
	private ${className}Dao ${lowerName}Dao;

	@Override
	public ${className}Entity get(String id) {
		return ${lowerName}Dao.get(id);
	}

	@Override
	public int update(${className}Entity ${lowerName}) {
		return ${lowerName}Dao.update(${lowerName});
	}

	@Override
	public void insert(${className}Entity ${lowerName}) {
		${lowerName}Dao.insert(${lowerName});
		
	}

	@Override
	public MiniDaoPage<${className}Entity> getAll(${className}Entity ${lowerName}, int page, int rows) {
		return ${lowerName}Dao.getAll(${lowerName}, page, rows);
	}

	@Override
	public void delete(${className}Entity ${lowerName}) {
		${lowerName}Dao.delete(${lowerName});
		
	}
}
