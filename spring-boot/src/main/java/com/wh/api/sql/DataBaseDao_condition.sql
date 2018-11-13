		<#if ( dataBase.type )?? && dataBase.type ?length gt 0>
		    /* 类型 */
			and db.type like CONCAT('%', :dataBase.type ,'%') 
		</#if>
		<#if ( dataBase.username )?? && dataBase.username ?length gt 0>
		    /* 用户名 */
			and db.username like CONCAT('%', :dataBase.username ,'%') 
		</#if>
		<#if ( dataBase.password )?? && dataBase.password ?length gt 0>
		    /* 密码 */
			and db.password like CONCAT('%', :dataBase.password ,'%') 
		</#if>
		<#if ( dataBase.driver )?? && dataBase.driver ?length gt 0>
		    /* 驱动 */
			and db.driver like CONCAT('%', :dataBase.driver ,'%') 
		</#if>
		<#if ( dataBase.url )?? && dataBase.url ?length gt 0>
		    /* 链接 */
			and db.url like CONCAT('%', :dataBase.url ,'%') 
		</#if>
		<#if ( dataBase.remarks )?? && dataBase.remarks ?length gt 0>
		    /* 备注 */
			and db.remarks like CONCAT('%', :dataBase.remarks ,'%') 
		</#if>
