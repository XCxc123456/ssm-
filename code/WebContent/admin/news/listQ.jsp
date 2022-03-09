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
 
	
	<table class="table table-bordered table-hover">

	<tr>
		<th width="5%">ID</th>
		<th width="10%">标题</th>
 
		<th width="10%">日期</th>
		
		<th width="40%">内容</th>
		
	</tr>
	
	<c:forEach var="news" items="${newsList}">
         <tr>
         	<td><p>${news.id}</p></td>
         	
         	<td><p>${news.name}</p></td>

         	<td><p>${news.riqi}</p></td>
         	
         	<td><p>${news.con}</p></td>

       	</tr>
     </c:forEach>
     
</table>

<br>${pageTool}<br>
</div>
</body>
</html>