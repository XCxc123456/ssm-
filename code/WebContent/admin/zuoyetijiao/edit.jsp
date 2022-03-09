<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>出库修改</title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="../css/bootstrap.css"/> 
</head>
<body>
<div class="container-fluid">

	<%@include file="../header.jsp"%>

	<br><br>
	
	<form class="form-horizontal" action="zuoyetijiaoUpdate" method="post">
		<input type="hidden" name="id" value="${zuoyetijiao.id}">
		<input type="hidden" name="zt" value="${zuoyetijiao.zt}">
 		<input type="hidden" name="shuliang" value="${zuoyetijiao.shuliang}">
 
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">作业名称</label>
			<div class="col-sm-6">
				  <select class="form-control" id="zuoyexxname" name="zuoyexxname">
					<c:forEach var="zuoyexx" items="${zuoyexxList}">
						<c:if test="${zuoyexx.name==zuoyetijiao.zuoyexxname}"><option selected="selected" value="${zuoyexx.name}">${zuoyexx.name}</option></c:if>
						<c:if test="${zuoyexx.name!=zuoyetijiao.zuoyexxname}"><option value="${zuoyexx.name}">${zuoyexx.name}</option></c:if>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">学生</label>
			<div class="col-sm-6">
			    <input type="text" name="teachername"  class="form-control"  id="input_name" value="${zuoyetijiao.teachername}" required="required"  readonly > 
			</div>
		</div>
 
		<div class="form-group">
			<label for="select_topic" class="col-sm-1 control-label">修改的作业</label>
			<div class="col-sm-6">
				<input type="file" name="zyurl"  id="input_file" required="required"> 
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