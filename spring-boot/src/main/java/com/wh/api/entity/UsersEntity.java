package com.wh.api.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 用户实体
 * @author: 王浩
 * @since：2018年08月02日 15时45分34秒 星期四 
 * @version:1.0
 */
public class UsersEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *主键	 */	private String id;	/**	 *用户名	 */	private String username;	/**	 *密码	 */	private String password;	/**	 *姓名	 */	private String realname;	/**	 *状态	 */	private Integer status;	public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getUsername() {	    return this.username;	}	public void setUsername(String username) {	    this.username=username;	}	public String getPassword() {	    return this.password;	}	public void setPassword(String password) {	    this.password=password;	}	public String getRealname() {	    return this.realname;	}	public void setRealname(String realname) {	    this.realname=realname;	}	public Integer getStatus() {	    return this.status;	}	public void setStatus(Integer status) {	    this.status=status;	}
}

