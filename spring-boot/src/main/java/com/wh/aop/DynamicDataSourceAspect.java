package com.wh.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.wh.core.datasourse.DynamicDataSourceContextHolder;

/**
 * 数据源切换 AOP
 * @ClassName: DynamicDataSourceAspect 
 * @Description: 为保证数据源受事物控制 需在service之前更换数据库
 * @author: 59533
 * @date: 2018年8月27日 下午10:00:41
 */
@Aspect
@Order(-1)
@Component
public class DynamicDataSourceAspect {
	/**  需要更换数据源的标志位  */
	public static final String SPILT_DYNAMIC = "#$@@";

	@Pointcut("execution(* com.wh.api.service.*.*(..))")
	public void pointCut() {
	}
	/**
	 * 方法执行前更换数据库   1.数据库需要放在第一个参数且为 String   2.第一个参数需要存在标志 
	 * @Title: doBeforeWithSlave 
	 * @Description: TODO 
	 * @param joinPoint void
	 * @author 59533
	 * @date 2018年8月27日下午10:34:13
	 */
	@Before(value = "pointCut()")
	public void doBeforeWithSlave(JoinPoint joinPoint) {
		try {

			Object[] args = joinPoint.getArgs();

			Method method = null;

			Class<?>[] argTypes = new Class[joinPoint.getArgs().length];
			for (int i = 0; i < args.length; i++) {
				argTypes[i] = args[i].getClass();
			}
			method = joinPoint.getTarget().getClass()
					.getMethod(joinPoint.getSignature().getName(), argTypes);
			
			System.err.println(method.getName());
			if (args.length>0 && args[0] instanceof String) {
				String str = (String) args[0];

				if(str.indexOf(SPILT_DYNAMIC)!=-1){  
					str = str.replace(SPILT_DYNAMIC, "");
					DynamicDataSourceContextHolder.setDataSourceType(str);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 执行完换回默认数据库
	 * @Title: doAfter 
	 */
	@After("pointCut()")
	public void doAfter(JoinPoint joinPoint) {
		DynamicDataSourceContextHolder.clearDataSourceType();
	}
}
