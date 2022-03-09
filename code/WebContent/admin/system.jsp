<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>学生添加</title>
<meta charset="utf-8" />
<link rel="stylesheet" href="css/bootstrap.css" />
</head>
<body>
<div class="container-fluid">

	<%@include file="header.jsp"%>

	<br><br>
	<form class="form-horizontal" action="userSave" method="post">
		<div class="form-group">
			<label for="input_name" class="col-sm-10">欢迎使用基于Web作业管理系统</label>
			 
		</div>
 
 
	</form>
	
	<span style="color:red;">${msg}</span>
</div>
</body>
</html>