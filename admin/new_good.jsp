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
        <li><a href="showGood">全部商品</a></li>
        <li><a href="new_good.jsp">新加商品</a></li>
        <li><a href="query_good.jsp">查询商品</a></li>
    </ul>
	<br>
	
	<form class="form-horizontal" action="newGood" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label for="input_pass" class="col-sm-1 control-label">商品名称</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="input_pass" name="name" required="required">
			</div>
		</div>
		
		<div class="form-group">
			<label for="input_pass_new" class="col-sm-1 control-label">封面</label>
			<div class="col-sm-5">
				<input name="file" type="file" class="form-control" id="input_pass" required="required">
				<!-- 
				<input type="text" class="form-control" id="input_pass" name="cover" required="required">
				 -->
			</div>
		</div>
		
		<div class="form-group">
			<label for="input_pass_new" class="col-sm-1 control-label">图片1</label>
			<div class="col-sm-5">
				<input name="file1" type="file" class="form-control" id="input_pass" required="required">
			</div>
		</div>
		
		<div class="form-group">
			<label for="input_pass_new" class="col-sm-1 control-label">图片2</label>
			<div class="col-sm-5">
				<input name="file2" type="file" class="form-control" id="input_pass" required="required">
			</div>
		</div>
		
		<div class="form-group">
			<label for="input_pass_new" class="col-sm-1 control-label">价格</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="input_pass" name="price" required="required">
			</div>
		</div>
		
		<div class="form-group">
			<label for="input_pass_new" class="col-sm-1 control-label">简介</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="input_pass" name="intro" required="required">
			</div>
		</div>
		
		<div class="form-group">
			<label for="input_pass_new" class="col-sm-1 control-label">库存</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="input_pass" name="stock" required="required">
			</div>
		</div>
		
		<div class="form-group">
			<label for="input_pass_new" class="col-sm-1 control-label">类型</label>
			<div class="col-sm-5">
				<select name="typeId" class="form-control" id="input_pass">
					<option value=1>手机</option>
					<option value=2>耳机</option>
					<option value=3>平板</option>
					<option value=4>笔记本</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-1 col-sm-10">
				<button type="submit" class="btn btn-success">提交增加</button>
			</div>
		</div>
	</form>
	
	<span style="color:green;">${msg}</span>
	
</div>	
</body>
</html>