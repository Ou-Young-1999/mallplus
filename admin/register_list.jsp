<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>登录列表</title>
<link rel="stylesheet" href="css/bootstrap.css"/> 
</head>
<body>
<div class="container-fluid">

	<%@include file="header.jsp" %>
	
	<br>
	
	<ul role="tablist" class="nav nav-tabs">
        <li <c:if test='${status==0}'>class="active"</c:if> role="presentation"><a href="showRegister">登录记录</a></li>
    </ul>
    
    <br>
	
	<table class="table table-bordered table-hover">

				<tr>
					<th width="10%">用户ID</th>
					<th width="15%">用户名</th>
					<th width="15%">人员类型</th>
					<th width="15%">IP地址</th>
					<th width="15%">操作</th>
					<th width="20%">操作时间</th>
				</tr>
				<c:forEach var="register" items="${registerList}">
			         <tr>
			         	<td><p>${register.userId}</p></td>
			         	<td><p>${register.userName}</p></td>
			         	<td><p>${register.personType}</p></td>
			         	<td><p>${register.ipAddress}</p></td>
			         	<td><p>${register.operateType}</p></td>
			         	<td><p>${register.systime}</p></td>
			       	</tr>
				</c:forEach>
</table>

<br>${pageTool}<br>
</div>
</body>
</html>