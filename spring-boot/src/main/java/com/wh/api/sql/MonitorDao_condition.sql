		<#if ( monitor.tProject )?? && monitor.tProject ?length gt 0>
		    /* 项目 */
			and m.t_project like CONCAT('%', :monitor.tProject ,'%') 
		</#if>
		<#if ( monitor.type )?? && monitor.type ?length gt 0>
		    /* 状态 */
			and m.type like CONCAT('%', :monitor.type ,'%') 
		</#if>
		<#if ( monitor.location )?? && monitor.location ?length gt 0>
		    /* 位置 */
			and m.location like CONCAT('%', :monitor.location ,'%') 
		</#if>
		<#if ( monitor.parameters )?? && monitor.parameters ?length gt 0>
		    /* 参数 */
			and m.parameters like CONCAT('%', :monitor.parameters ,'%') 
		</#if>
		<#if ( monitor.parametersType )?? && monitor.parametersType ?length gt 0>
		    /* 参数种类 */
			and m.parameters_type like CONCAT('%', :monitor.parametersType ,'%') 
		</#if>
		<#if ( monitor.token )?? && monitor.token ?length gt 0>
		    /* token */
			and m.token like CONCAT('%', :monitor.token ,'%') 
		</#if>
		<#if ( monitor.error )?? && monitor.error ?length gt 0>
		    /* 错误 */
			and m.error like CONCAT('%', :monitor.error ,'%') 
		</#if>
		<#if ( monitor.errorInfo )?? && monitor.errorInfo ?length gt 0>
		    /* 详细错误 */
			and m.error_info like CONCAT('%', :monitor.errorInfo ,'%') 
		</#if>
		<#if ( monitor.createTime )?? && monitor.createTime ?length gt 0>
		    /* 创建时间 */
			and m.create_time like CONCAT('%', :monitor.createTime ,'%') 
		</#if>
		order by m.create_time  desc
