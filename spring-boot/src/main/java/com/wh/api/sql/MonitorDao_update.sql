UPDATE monitor
SET 
	   <#if monitor.tProject ?exists>
		   t_project = :monitor.tProject,
		</#if>
	   <#if monitor.type ?exists>
		   type = :monitor.type,
		</#if>
	   <#if monitor.location ?exists>
		   location = :monitor.location,
		</#if>
	   <#if monitor.parameters ?exists>
		   parameters = :monitor.parameters,
		</#if>
	   <#if monitor.parametersType ?exists>
		   parameters_type = :monitor.parametersType,
		</#if>
	   <#if monitor.token ?exists>
		   token = :monitor.token,
		</#if>
	   <#if monitor.error ?exists>
		   error = :monitor.error,
		</#if>
	   <#if monitor.errorInfo ?exists>
		   error_info = :monitor.errorInfo,
		</#if>
		<#if monitor.createTime ?exists>
		   create_time = :monitor.createTime,
		</#if>
WHERE id = :monitor.id