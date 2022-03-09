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
	<form class="form-horizontal" action="userSave" method="post">
		<div class="form-group">
			<label for="input_name" class="col-sm-10"><span style="color:red;">出库失败，库存数量不足！</span></label>
			 
		</div>
 
 
	</form>
	
	<span style="color:red;">${msg}</span>
</div>
</body>
</html>