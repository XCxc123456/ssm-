<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>作业添加</title>
<meta charset="utf-8" />
<link rel="stylesheet" href="css/bootstrap.css" />
</head>
<body>
<div class="container-fluid">
	<%@include file="header.jsp"%>

	<br><br>
	<form class="form-horizontal" action="zuoyexxSave" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">名称</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="input_name" name="name"  required="required">
			</div>
		</div>
 
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">介绍</label>
			<div class="col-sm-6">
				<textarea rows="5" cols="50"  class="form-control" id="input_name" name="intro" ></textarea>
			</div>
		</div>
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">人数</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="input_name" name="renshu" >
			</div>
		</div>
		<div class="form-group">
			<label for="input_file" class="col-sm-1 control-label">作业文件</label> 
			<div class="col-sm-6">
				<input type="file" name="cover"  id="input_file" required="required"> 
			</div>
		</div>

		<div class="form-group">
			<label for="select_topic" class="col-sm-1 control-label">课程</label>
			<div class="col-sm-6">
				<select class="form-control" id="select_topic" name="typeId">
					<c:forEach var="type" items="${typeList}">
						<option value="${type.id}">${type.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>

<% 
	String mname= session.getAttribute("mname").toString();
%>

		<div class="form-group">
			<label for="select_topic" class="col-sm-1 control-label">老师</label>
			<div class="col-sm-6">
				<input type="text" name="teachername"  class="form-control"  id="input_name" value="<%=mname%>" required="required"  readonly > 
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-1 col-sm-10">
			    <input type="hidden" name="shuliang" value="0"/>
			    <input type="hidden" name="banji" value="1"/>
				<button type="submit" class="btn btn-success">提交保存</button>
			</div>
		</div>
	</form>
</div>
</body>
</html>