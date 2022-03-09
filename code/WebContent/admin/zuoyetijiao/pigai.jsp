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
	
	<form class="form-horizontal" action="zuoyetijiaoPigai" method="post">
		<input type="hidden" name="id" value="${zuoyetijiao.id}">

		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">作业名称</label>
			<div class="col-sm-6">
				  ${zuoyetijiao.zuoyexxname}
			</div>
		</div>
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">学生</label>
			<div class="col-sm-6">
				 ${zuoyetijiao.teachername}
			</div>
		</div>
 
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">成绩</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="input_name" name="shuliang" value="${zuoyetijiao.shuliang}">
			</div>
		</div>
		<div class="form-group">
			<label for="select_topic" class="col-sm-1 control-label">状态</label>
			<div class="col-sm-6">
				<select class="form-control" id="select_topic" name="zt">
					<option value="完成">完成</option>
					<option value="重新做">重新做</option>
				</select>
			</div>
		</div>
		
		
		<div class="form-group">
			<div class="col-sm-offset-1 col-sm-10">
				<button type="submit" class="btn btn-success">提交</button>
			</div>
		</div>
	</form>
	
	<span style="color:red;">${msg}</span>
	
</div>	
</body>
</html>