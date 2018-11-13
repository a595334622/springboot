package com.wh.api.service.impl;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.wh.api.service.ProductService;
/**
 * dubbo服务提供实现
 * @ClassName: ProductServiceImpl 
 * @Description: TODO
 * @author: 59533
 * @date: 2018年8月29日 上午10:38:08
 */
@Service(interfaceClass = ProductService.class)
@Component
public class ProductServiceImpl implements ProductService {
 
	@Override
	public String product(String str) {
		return "已接收" + str;
	}
 
}