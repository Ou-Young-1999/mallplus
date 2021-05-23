<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>新加商品</title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="css/bootstrap.css"/> 
</head>
<body>
<div class="container-fluid">

	<%@include file="header.jsp"%>

	<br>
	<ul role="tablist" class="nav nav-tabs">
        <li><a href="showUser">全部用户</a></li>
        <li><a href="query_user.jsp">查询用户</a></li>
    </ul>
	<br>
	
	<form class="form-horizontal" action="queryUser" method="post">
		<div class="form-group">
			<label for="input_pass" class="col-sm-1 control-label">用户关键字</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="input_pass" name="name" required="required">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-1 col-sm-10">
				<button type="submit" class="btn btn-success">提交查询</button>
			</div>
		</div>
	</form>
	
	    <br>
	

     
</table>
	
	<span style="color:red;">${msg}</span>
	
</div>	
</body>
</html>