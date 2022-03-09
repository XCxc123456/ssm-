<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>老师列表</title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="../css/bootstrap.css"/> 
</head>
<body>
<div class="container-fluid">

	<%@include file="../header.jsp"%>
	
	<div class="text-right"><a class="btn btn-warning" href="teacherAdd">添加老师</a></div>
		
	<br>
	
	<table class="table table-bordered table-hover">

	<tr>
		<th width="5%">ID</th>
		<th width="10%">用户名</th>
		<th width="10%">密码</th>
		<th width="10%">名称</th>
		<th width="10%">电话</th>
		
		<th width="10%">地址</th>
		<th width="10%">职称</th>
		<th width="10%">邮箱</th>
		
		<th width="10%">操作</th>
	</tr>
	
	<c:forEach var="teacher" items="${teacherList}">
         <tr>
         	<td><p>${teacher.id}</p></td>
         	<td><p>${teacher.username}</p></td>
         	<td><p>${teacher.password}</p></td>
         	<td><p>${teacher.name}</p></td>
         	
         	<td><p>${teacher.phone}</p></td>
         	<td><p>${teacher.address}</p></td>
         	<td><p>${teacher.lianxiren}</p></td>
         	
         	<td><p>${teacher.youxiang}</p></td>

			<td>
				<a class="btn btn-primary" href="teacherEdit?id=${teacher.id}">修改</a>
				<a class="btn btn-danger" href="teacherDelete?id=${teacher.id}" onclick="return confirm('确定删除吗?')" >删除</a>
			</td>
       	</tr>
     </c:forEach>
     
</table>

<br>${pageTool}<br>
</div>
</body>
</html>