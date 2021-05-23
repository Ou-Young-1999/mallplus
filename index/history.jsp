<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<title>我的订单</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="layer/layer.js"></script>
	<script type="text/javascript" src="js/cart.js"></script>
</head>
<body>
	
	<jsp:include page="header.jsp"/>
	
	<!--cart-items-->
	<div class="cart-items">
		<div class="container">
		
		<c:if test="${msg!=null}"><div class="alert alert-success">${msg}</div></c:if>
			<h2>浏览记录</h2>
			
				<table class="table table-bordered table-hover">

				<tr>
					<th width="15%">商品ID</th>
					<th width="15%">商品名称</th>
					<th width="15%">浏览时间</th>
					<th width="15%">商品类型</th>
				</tr>
				<c:forEach var="history" items="${histories}">
			         <tr>
			         	<td><p>${history.goodId}</p></td>
			         	<td><p>${history.goodName}</p></td>
			         	<td><p>${history.systime}</p></td>
			         	<c:if test="${history.goodType==1}"><td><p>手机</p></td></c:if>
			         	
			         	<c:if test="${history.goodType==2}"><td><p>耳机</p></td></c:if>
			         	
			         	<c:if test="${history.goodType==3}"><td><p>平板</p></td></c:if>
			         	
			         	<c:if test="${history.goodType==4}"><td><p>笔记本</p></td></c:if>
			         	
			       	</tr>
				</c:forEach>
			     
			</table>
			
			<c:if test="${histories==null}"><div class="alert alert-info">空空如也</div></c:if>
			
		</div>
	</div>
	

</body>
</html>