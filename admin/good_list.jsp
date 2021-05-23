<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>商品列表</title>
<link rel="stylesheet" href="css/bootstrap.css"/> 
</head>
<body>
<div class="container-fluid">

	<%@include file="header.jsp" %>
	
	<br>
	
	<ul role="tablist" class="nav nav-tabs">
        <li><a href="showGood">全部商品</a></li>
        <li><a href="new_good.jsp">新加商品</a></li>
        <li><a href="query_good.jsp">查询商品</a></li>
    </ul>
    <br>
	
	<table class="table table-bordered table-hover">

	<tr>
		<th width="5%">ID</th>
		<th width="5%">名称</th>
		<th width="10%">封面</th>
		<th width="10%">图片1</th>
		<th width="10%">图片2</th>
		<th width="10%">价格</th>
		<th width="15%">简介</th>
		<th width="10%">库存</th>
		<th width="10%">类型</th>
		<th width="10%">操作</th>
	</tr>
	
	<c:forEach var="good" items="${goodList}">
         <tr>
         	<td><a href="queryGoodById?id=${good.id}">${good.id}</a></td>
         	<td><p>${good.name}</p></td>
         	<td><img src="../index/images/${good.cover}" height="80px" width="110px"></td>
         	<td><img src="../index/images/${good.image1}" height="80px" width="110px"></td>
         	<td><img src="../index/images/${good.image2}" height="80px" width="110px"></td>
         	<td><p>${good.price}</p></td>
         	<td><p>${good.intro}</p></td>
         	<td><p>${good.stock}</p></td>
         	<c:if test="${good.typeId==1}"><td><p>手机</p></td></c:if>
         	<c:if test="${good.typeId==2}"><td><p>耳机</p></td></c:if>
         	<c:if test="${good.typeId==3}"><td><p>平板</p></td></c:if>
         	<c:if test="${good.typeId==4}"><td><p>笔记本</p></td></c:if>
         	
         	<td><a onclick="window.confirm('确定删除?')?this.href='deleteGood?id=${good.id}':this.href='javascript:void()';">删除</a></td>
       	</tr>
	</c:forEach>
     
</table>

<br>${pageTool}<br>
</div>
</body>
</html>