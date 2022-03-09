<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>老师修改</title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="../css/bootstrap.css"/> 
</head>
<body>
<div class="container-fluid">

	<%@include file="../header.jsp"%>

	<br><br>
	
	<form class="form-horizontal" action="teacherUpdate1" method="post">
		<input type="hidden" name="id" value="${teacher.id}">
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">用户名</label>
			<div class="col-sm-5">
			<input type="text" class="form-control" id="input_name" name="username" required="required" value="${teacher.username}">
			</div>
		</div>
		
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">密码</label>
			<div class="col-sm-5">
				<input type="password" class="form-control" id="input_name" name="password" required="required" value="${teacher.password}">
			</div>
		</div>
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">电话</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="input_name" name="phone"  value="${teacher.phone}">
			</div>
		</div>
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">地址</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="input_name" name="address" value="${teacher.address}">
			</div>
		</div>
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">姓名</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="input_name" name="name" value="${teacher.name}">
			</div>
		</div>
		 <div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">职称</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="input_name" name="lianxiren" value="${teacher.lianxiren}">
			</div>
		</div>
		 <div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">邮箱</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="input_name" name="youxiang" value="${teacher.youxiang}">
			</div>
		</div>
		 <div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">内容</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="input_name" name="con" value="${teacher.con}">
			</div>
		</div>
		
		
		<div class="form-group">
			<div class="col-sm-offset-1 col-sm-10">
				<button type="submit" class="btn btn-success">提交修改</button>
			</div>
		</div>
	</form>
	
	<span style="color:red;">${msg}</span>
	
</div>	
</body>
</html>