<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>订单列表</title>
<link rel="stylesheet" href="css/bootstrap.css"/> 
</head>
<body>
<div class="container-fluid">

	<%@include file="header.jsp" %>
	
	<br>
	
	<ul role="tablist" class="nav nav-tabs">
        <li <c:if test='${status==0}'>class="active"</c:if> role="presentation"><a href="showOrder">全部订单</a></li>
    </ul>
    
    <br>
	
	<table class="table table-bordered table-hover">

				<tr>
					<th width="10%">商品名称</th>
					<th width="10%">商品单价</th>
					<th width="10%">商品数量</th>
					<th width="10%">付款方式</th>
					<th width="10%">下单时间</th>
					<th width="10%">地址</th>
					<th width="10%">电话</th>
					<th width="10%">姓名</th>
					<th width="10%">用户编号</th>
				</tr>
				<c:set var="sum" value="0" />
				<c:forEach var="order" items="${orderList}">
			         <tr>
			         	<td><p>${order.goodName}</p></td>
			         	<td><p>${order.price}</p></td>
			         	<td><p>${order.amount}</p></td>
			         	<td><p>${order.paytype}</p></td>
			         	<td><p>${order.systime}</p></td>
			         	<td><p>${order.address}</p></td>
			         	<td><p>${order.phone}</p></td>
			         	<td><p>${order.userName}</p></td>
			         	<td><p>${order.userId}</p></td>
			       	</tr>
			       	<c:set value="${(sum + order.price)*order.amount}" var="sum" ></c:set>
				</c:forEach>
				<p>销售额为${sum }元</p>
</table>

<br>${pageTool}<br>
</div>
</body>
</html>