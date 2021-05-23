<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>商品列表</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/simpleCart.min.js"></script>
	<script type="text/javascript" src="layer/layer.js"></script>
	<script type="text/javascript" src="js/cart.js"></script>
</head>
<body>
	
	<jsp:include page="header.jsp"/>
	
	<!--products-->
	<div class="products">	 
		<div class="container">
			<div class="col-md-12 product-model-sec">
				<c:forEach var="good" items="${goodList}">
					<div class="product-grid">
						<a href="detail?goodid=${good.id}">				
							<div class="more-product"><span> </span></div>						
							<div class="product-img b-link-stripe b-animate-go  thickbox">
								<img src="images/${good.cover}" class="img-responsive" alt="${good.name}" width="240" height="240">
								<div class="b-wrapper">
									<h4 class="b-animate b-from-left  b-delay03">							
										<button>查看详情</button>
									</h4>
								</div>
							</div>
						</a>				
						<div class="product-info simpleCart_shelfItem">
							<div class="product-info-cust prt_name">
								<h4>${good.name}</h4>								
								<span class="item_price">¥ ${good.price}</span>
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
								<div class="clearfix"> </div>
							</div>												
						</div>
					</div>
				</c:forEach>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!--//products-->	

</body>
</html>