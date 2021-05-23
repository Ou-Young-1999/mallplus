<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>商品详情</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/flexslider.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.flexslider.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="layer/layer.js"></script>
	<script type="text/javascript" src="js/cart.js"></script>
	<script>
		$(function() {
		  $('.flexslider').flexslider({
			animation: "slide",
			controlNav: "thumbnails"
		  });
		});
	</script>
</head>
<body>
	 
	<jsp:include page="header.jsp"/>
	
	<!--//single-page-->
	<div class="single">
		<div class="container">
			<div class="single-grids">				
				<div class="col-md-4 single-grid">		
					<div class="flexslider">
						<%-- <div class="thumb-image"> <img src="../${good.cover}" data-imagezoom="true" class="img-responsive"> </div> --%>
						<ul class="slides">
							<li data-thumb="images/${good.cover}">
								<div class="thumb-image"> <img src="images/${good.cover}" data-imagezoom="true" class="img-responsive"> </div>
							</li>
							<li data-thumb="images/${good.image1}">
								 <div class="thumb-image"> <img src="images/${good.image1}" data-imagezoom="true" class="img-responsive"> </div>
							</li>
							<li data-thumb="images/${good.image2}">
							   <div class="thumb-image"> <img src="images/${good.image2}" data-imagezoom="true" class="img-responsive"> </div>
							</li> 
						</ul>
					</div>
				</div>	
				<div class="col-md-4 single-grid simpleCart_shelfItem">		
					<h3>${good.name}</h3>
					<div class="tag">
						<c:if test="${good.typeId==1}"><p>分类 : 手机</p></c:if>
						<c:if test="${good.typeId==2}"><p>分类 : 耳机</p></c:if>
						<c:if test="${good.typeId==3}"><p>分类 : 平板</p></c:if>
						<c:if test="${good.typeId==4}"><p>分类 : 笔记本</p></c:if>
					</div>
					<p>介绍: ${good.intro}</p>
					<div class="galry">
						<div class="prices">
							<h5 class="item_price">¥ ${good.price}</h5>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="btn_form">
						<c:if test="${sessionScope.user!=null}">
								<form action="buy">
								<input type="hidden" name="goodid" value="${good.id}">
								<input type="hidden" name="userid" value="${sessionScope.user.id}">
								<input type="submit" class="item_add items" value="加入购物车"">
								</form>
						</c:if>
						<c:if test="${sessionScope.user==null}">
								<input type="submit" class="item_add items" value="加入购物车" onclick="javascript:alert('请先登录！')">
						</c:if>
					</div>
				</div>
				
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>

</body>
</html>