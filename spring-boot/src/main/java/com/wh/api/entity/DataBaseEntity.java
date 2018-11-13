package com.wh.api.entity;

import java.io.Serializable;

/**
 * 数据库切换实体
 * @author: 王浩
 * @since：2018年08月27日 19时25分27秒 星期一 
 * @version:1.0
 */
public class DataBaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *id	 */	private String id;	/**	 *类型	 */	private String type;	/**	 *用户名	 */	private String username;	/**	 *密码	 */	private String password;	/**	 *驱动	 */	private String driver;	/**	 *链接	 */	private String url;	/**	 *备注	 */	private String remarks;	public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getType() {	    return this.type;	}	public void setType(String type) {	    this.type=type;	}	public String getUsername() {	    return this.username;	}	public void setUsername(String username) {	    this.username=username;	}	public String getPassword() {	    return this.password;	}	public void setPassword(String password) {	    this.password=password;	}	public String getDriver() {	    return this.driver;	}	public void setDriver(String driver) {	    this.driver=driver;	}	public String getUrl() {	    return this.url;	}	public void setUrl(String url) {	    this.url=url;	}	public String getRemarks() {	    return this.remarks;	}	public void setRemarks(String remarks) {	    this.remarks=remarks;	}
}

