<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
</head>
<body>
	<!--header-->
	<div class="header">
		<div class="container">
			<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<h1 class="navbar-brand"><a href="index.jsp">网工欧阳学强</a></h1>
				</div>
				<!--navbar-header-->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="getGood" <c:if test="${flag==1}">class="active"</c:if>>全部</a></li>
						<li><a href="getGoodByTypeId?typeid=1" <c:if test="${flag==5}">class="active"</c:if>>手机</a></li>
						<li><a href="getGoodByTypeId?typeid=2" <c:if test="${flag==6}">class="active"</c:if>>耳机</a></li>
						<li><a href="getGoodByTypeId?typeid=3" <c:if test="${flag==5}">class="active"</c:if>>平板</a></li>
						<li><a href="getGoodByTypeId?typeid=4" <c:if test="${flag==6}">class="active"</c:if>>笔记本</a></li>
						
						<c:if test="${sessionScope.user==null}">
							<li><a href="register.jsp" >注册</a></li>
							<li><a href="login.jsp">登录</a></li>
						</c:if>
						<c:if test="${sessionScope.user!=null}">
							<li><a href="recommend?userid=${sessionScope.user.id}" <c:if test="${flag==6}">class="active"</c:if>>推荐</a></li>
							<li><a href="order?userid=${sessionScope.user.id}" <c:if test="${flag==2}">class="active"</c:if>>我的订单</a></li>
							<li><a href="history?userid=${sessionScope.user.id}" <c:if test="${flag==2}">class="active"</c:if>>浏览记录</a></li>
							<li><a href="logout">退出</a></li>
						</c:if>
						<li><a href="../admin.jsp" target="_blank">后台管理</a></li>
					</ul> 
					<!--/.navbar-collapse-->
				</div>
				<!--//navbar-header-->
			</nav>
			<div class="header-info">
				<div class="header-right cart">
				<c:if test="${sessionScope.user!=null}">
					<a href="cart?userid=${sessionScope.user.id}">
						<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"><span class="card_num">${count==null ? '' :count}</span></span>
					</a>
				</c:if>
				</div>
				<div class="header-right login">
					<c:if test="${sessionScope.user!=null}">
						<a href="update.jsp"><span class="glyphicon glyphicon-user" aria-hidden="true">${sessionScope.user.username}</span></a>
					</c:if>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>

</body>
</html>