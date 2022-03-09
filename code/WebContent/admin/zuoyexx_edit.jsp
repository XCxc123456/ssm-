<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>作业编辑</title>
<meta charset="utf-8" />
<link rel="stylesheet" href="css/bootstrap.css" />
</head>
<body>
<div class="container-fluid">
	<%@include file="header.jsp"%>

	<br><br>
	<form class="form-horizontal" action="zuoyexxUpdate" method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${zuoyexx.id}"/>
		<input type="hidden" name="cover" value="${zuoyexx.cover}"/>
		<input type="hidden" name="shuliang" value="${zuoyexx.shuliang}"/>
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">名称</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="input_name" name="name" value="${zuoyexx.name}" required="required">
			</div>
		</div>
 
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">介绍</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="input_name" name="intro" value="${zuoyexx.intro}">
			</div>
		</div>
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">人数</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="input_name" name="renshu" value="${zuoyexx.renshu}" required="required">
			</div>
		</div>
		<div class="form-group">
			<label for="input_file" class="col-sm-1 control-label">作业文件</label> 
			<div class="col-sm-6">
				<input type="file" name="cover"  id="input_file"> 
			</div>
		</div>
 
		<div class="form-group">
			<label for="select_topic" class="col-sm-1 control-label">课程</label>
			<div class="col-sm-6">
				<select class="form-control" id="select_topic" name="typeId">
					<c:forEach var="type" items="${typeList}">
						<c:if test="${type.id==zuoyexx.type.id}"><option selected="selected" value="${type.id}">${type.name}</option></c:if>
						<c:if test="${type.id!=zuoyexx.type.id}"><option value="${type.id}">${type.name}</option></c:if>
					</c:forEach>
				</select>
			</div>
		</div>
		
		<div class="form-group">
			<label for="select_topic" class="col-sm-1 control-label">老师</label>
			<div class="col-sm-6">
				<select class="form-control" id="select_topic" name="teachername" readonly>
					<c:forEach var="teacher" items="${teacherList}">
						<c:if test="${teacher.name==zuoyexx.teachername}"><option selected="selected"  value="${teacher.name}">${teacher.name}</option></c:if>
						<c:if test="${teacher.name!=zuoyexx.teachername}"><option value="${teacher.name}">${teacher.name}</option></c:if>
					</c:forEach>
				</select>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-offset-1 col-sm-10">
				<button type="submit" class="btn btn-success">提交修改</button>
			</div>
		</div>
	</form>
</div>
</body>
</html>