<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>考试列表</title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="../css/bootstrap.css"/> 
</head>
<body>
<div class="container-fluid">

	<%@include file="../header.jsp"%>
	
	<div class="text-right"><a class="btn btn-warning" href="kaoshixxAdd">添加考试</a></div>
		
	<br>
	
	<table class="table table-bordered table-hover">

	<tr>
		<th width="5%">ID</th>
		<th width="10%">标题</th>
 
		<th width="10%">日期</th>
		
		<th width="20%">内容</th>
		
		<th width="20%">下载试题</th>
 
		<th width="10%">操作</th>
	</tr>
	
	<c:forEach var="kaoshixx" items="${kaoshixxList}">
         <tr>
         	<td><p>${kaoshixx.id}</p></td>
         	
         	<td><p>${kaoshixx.name}</p></td>

         	<td><p>${kaoshixx.riqi}</p></td>
         	
         	<td><p>${kaoshixx.con}</p></td>
         	
         	<td><p><a class="btn btn-success" href="../../${kaoshixx.url}">下载</a></p></td>

			<td>
				<a class="btn btn-primary" href="kaoshixxEdit?id=${kaoshixx.id}">修改</a>
				<a class="btn btn-danger" href="kaoshixxDelete?id=${kaoshixx.id}" onclick="return confirm('确定删除吗?')" >删除</a>
			</td>
       	</tr>
     </c:forEach>
     
</table>

<br>${pageTool}<br>
</div>
</body>
</html>