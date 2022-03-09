<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>老师添加</title>
<meta charset="utf-8" />
<link rel="stylesheet" href="../css/bootstrap.css" />

<script type="text/javascript" src="js/jquery.js"></script>
 
 
</head>
<body>
<div class="container-fluid">

	<%@include file="../header.jsp"%>

	<br><br>
	<form class="form-horizontal" action="zuoyetijiaoSave" method="post" enctype="multipart/form-data">
		<!--  
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">作业类型</label>
			<div class="col-sm-6">
				 <select class="form-control" id="typesname" name="typesname">
					<c:forEach var="type" items="${typeList}">
						<option value="${type.id}">${type.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		-->
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">作业名称</label>
			<div class="col-sm-6">
				 <select class="form-control" id="zuoyexxname" name="zuoyexxname">
					<c:forEach var="zuoyexx" items="${zuoyexxList}">
						<option value="${zuoyexx.name}">${zuoyexx.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
<% 
	String mname= session.getAttribute("mname").toString();
%>
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">学生姓名</label>
			<div class="col-sm-6">
				<input type="text" name="teachername"  class="form-control"  id="input_name" value="<%=mname%>" required="required"  readonly > 
			</div>
		</div>
 
		<div class="form-group">
			<label for="select_topic" class="col-sm-1 control-label">上传完成的作业</label>
			<div class="col-sm-6">
				<input type="file" name="zyurl"  id="input_file" required="required"> 
			</div>
		</div>
 
		
		<div class="form-group">
			<div class="col-sm-offset-1 col-sm-10">
			    <input type="hidden" name="zt" value="待批阅"/>
			    <input type="hidden" name="shuliang" value="0"/>
				<button type="submit" class="btn btn-success">提交保存</button>
			</div>
		</div>
	</form>
	
	<span style="color:red;">${msg}</span>
</div>


 
 
</body>
</html>