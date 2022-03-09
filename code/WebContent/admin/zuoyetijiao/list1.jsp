<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>出库列表</title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="../css/bootstrap.css"/> 
</head>
<body>
<div class="container-fluid">

	<%@include file="../header.jsp"%>
	
 <c:if test="${msg!=null}"><div class="alert alert-danger text-center">${msg}</div></c:if>
	
	<table class="table table-bordered table-hover">

	<tr>
		<th width="5%">ID</th>
		<th width="10%">作业名称</th>
	 
		<th width="10%">学生</th>
		
		
		<th width="10%">查看作业</th>
		
		<th width="10%">成绩</th>
		<th width="10%">状态</th>
 
		<th width="10%">批阅</th>
	</tr>
	
	<c:forEach var="zuoyetijiao" items="${zuoyetijiaoList}">
         <tr>
         	<td><p>${zuoyetijiao.id}</p></td>
         	<td><p>${zuoyetijiao.zuoyexxname}</p></td>
    
         	<td><p>${zuoyetijiao.teachername}</p></td>
         	
         	
         	<td><p><a class="btn btn-success" href="../../${zuoyetijiao.zyurl}">下载</a></p></td>
         	<td><p>${zuoyetijiao.shuliang}</p></td>
         	<td><p>${zuoyetijiao.zt}</p></td>
 
			<td>
				<c:if test="${zuoyetijiao.zt=='待批阅'}">
					<a class="btn btn-danger" href="zuoyetijiaoDelete1?id=${zuoyetijiao.id}"   >批阅</a>
				</c:if>
			</td>
       	</tr>
     </c:forEach>
     
</table>

<br>${pageTool}<br>
</div>
</body>
</html>