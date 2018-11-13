		<#if ( users.username )?? && users.username ?length gt 0>
		    /* 用户名 */
			and u.username like CONCAT('%', :users.username ,'%') 
		</#if>
		<#if ( users.password )?? && users.password ?length gt 0>
		    /* 密码 */
			and u.password like CONCAT('%', :users.password ,'%') 
		</#if>
		<#if ( users.realname )?? && users.realname ?length gt 0>
		    /* 姓名 */
			and u.realname like CONCAT('%', :users.realname ,'%') 
		</#if>
		<#if ( users.status )?? && users.status ?length gt 0>
		    /* 状态 */
			and u.status like CONCAT('%', :users.status ,'%') 
		</#if>
