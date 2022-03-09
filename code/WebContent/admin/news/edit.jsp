<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>公告修改</title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="../css/bootstrap.css"/> 
</head>
<body>
<div class="container-fluid">

	<%@include file="../header.jsp"%>

	<br><br>
	
	<form class="form-horizontal" action="newsUpdate" method="post">
		<input type="hidden" name="id" value="${news.id}">
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">标题</label>
			<div class="col-sm-5">
			<input type="text" class="form-control" id="input_name" name="name" required="required" value="${news.name}">
			</div>
		</div>

		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">日期</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="input_name" name="riqi"  value="${news.riqi}">
			</div>
		</div>
	
		 <div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">内容</label>
			<div class="col-sm-5">
				<textarea rows="5" cols="50"  class="form-control" id="input_name" name="con" >${news.con}</textarea>
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