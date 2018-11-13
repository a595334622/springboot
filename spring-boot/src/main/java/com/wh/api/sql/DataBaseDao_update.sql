UPDATE data_base
SET 
	   <#if dataBase.type ?exists>
		   type = :dataBase.type,
		</#if>
	   <#if dataBase.username ?exists>
		   username = :dataBase.username,
		</#if>
	   <#if dataBase.password ?exists>
		   password = :dataBase.password,
		</#if>
	   <#if dataBase.driver ?exists>
		   driver = :dataBase.driver,
		</#if>
	   <#if dataBase.url ?exists>
		   url = :dataBase.url,
		</#if>
	   <#if dataBase.remarks ?exists>
		   remarks = :dataBase.remarks,
		</#if>
WHERE id = :dataBase.id