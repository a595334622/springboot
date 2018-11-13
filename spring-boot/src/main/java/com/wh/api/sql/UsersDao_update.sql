UPDATE users
SET 
	   <#if users.username ?exists>
		   username = :users.username,
		</#if>
	   <#if users.password ?exists>
		   password = :users.password,
		</#if>
	   <#if users.realname ?exists>
		   realname = :users.realname,
		</#if>
	   <#if users.status ?exists>
		   status = :users.status,
		</#if>
WHERE id = :users.id