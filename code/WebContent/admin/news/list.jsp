<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>公告列表</title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="../css/bootstrap.css"/> 
</head>
<body>
<div class="container-fluid">

	<%@include file="../header.jsp"%>
	
	<div class="text-right"><a class="btn btn-warning" href="newsAdd">添加公告</a></div>
		
	<br>
	
	<table class="table table-bordered table-hover">

	<tr>
		<th width="5%">ID</th>
		<th width="10%">标题</th>
 
		<th width="10%">日期</th>
		
		<th width="40%">内容</th>
 
		<th width="10%">操作</th>
	</tr>
	
	<c:forEach var="news" items="${newsList}">
         <tr>
         	<td><p>${news.id}</p></td>
         	
         	<td><p>${news.name}</p></td>

         	<td><p>${news.riqi}</p></td>
         	
         	<td><p>${news.con}</p></td>

			<td>
				<a class="btn btn-primary" href="newsEdit?id=${news.id}">修改</a>
				<a class="btn btn-danger" href="newsDelete?id=${news.id}" onclick="return confirm('确定删除吗?')" >删除</a>
			</td>
       	</tr>
     </c:forEach>
     
</table>

<br>${pageTool}<br>
</div>
</body>
</html>