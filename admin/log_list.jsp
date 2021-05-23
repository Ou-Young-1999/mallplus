<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>操作列表</title>
<link rel="stylesheet" href="css/bootstrap.css"/> 
</head>
<body>
<div class="container-fluid">

	<%@include file="header.jsp" %>
	
	<br>
	
	<ul role="tablist" class="nav nav-tabs">
        <li <c:if test='${status==0}'>class="active"</c:if> role="presentation"><a href="showLog">操作日志</a></li>
    </ul>
    
    <br>
	
	<table class="table table-bordered table-hover">

				<tr>
					<th width="5%">用户ID</th>
					<th width="10%">用户名</th>
					<th width="10%">IP地址</th>
					<th width="10%">操作对象</th>
					<th width="5%">对象ID</th>
					<th width="10%">对象名称</th>
					<th width="10%">操作内容</th>
					<th width="20%">操作时间</th>
				</tr>
				<c:forEach var="log" items="${logList}">
			         <tr>
			         	<td><p>${log.userId}</p></td>
			         	<td><p>${log.userName}</p></td>
			         	<td><p>${log.ipAddress}</p></td>
			         	<td><p>${log.operateObject}</p></td>
			         	<td><p>${log.operateId}</p></td>
			         	<td><p>${log.operateName}</p></td>
			         	<td><p>${log.content}</p></td>
			         	<td><p>${log.systime}</p></td>
			       	</tr>
				</c:forEach>
</table>

<br>${pageTool}<br>
</div>
</body>
</html>