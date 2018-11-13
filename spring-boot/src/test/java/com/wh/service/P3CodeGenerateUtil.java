package com.wh.service;



import org.jeecgframework.p3.cg.def.FtlDef;
import org.jeecgframework.p3.cg.factory.CodeGenerateFactory;

/**
 * 描述：代码生成器工具类（支持单表）
 * 
 * @author：zhoujf
 * @since：
 * @version:1.0
 */
public class P3CodeGenerateUtil {

	public static void main(String[] args) {
		
		//表名（多个表可用逗号隔开）
		String tables = "monitor";
		
		String split = ",";
		
		//执行代码生成器
		for (String tableName : tables.split(split)) {
			CodeGenerateFactory.codeGenerateByFTL(tableName, "故障定位", FtlDef.KEY_TYPE_02);
		}
	}
}
