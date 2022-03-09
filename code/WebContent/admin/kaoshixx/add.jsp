<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>考试添加</title>
<meta charset="utf-8" />
<link rel="stylesheet" href="../css/bootstrap.css" />
</head>
<body>
<div class="container-fluid">

	<%@include file="../header.jsp"%>

	<br><br>
	<form class="form-horizontal" action="kaoshixxSave" method="post"  enctype="multipart/form-data">
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">题目</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="input_name" name="name" required="required">
			</div>
		</div>
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">日期</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="input_name" name="riqi" >
			</div>
		</div>
		 <div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">内容</label>
			<div class="col-sm-6">
				<textarea rows="5" cols="50"  class="form-control" id="input_name" name="con" ></textarea>
			</div>
		</div>
		<div class="form-group">
			<label for="input_file" class="col-sm-1 control-label">考试文件</label> 
			<div class="col-sm-6">
				<input type="file" name="url"  id="input_file" required="required"> 
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-1 col-sm-10">
				<button type="submit" class="btn btn-success">提交保存</button>
			</div>
		</div>
	</form>
	
	<span style="color:red;">${msg}</span>
</div>
</body>
</html>