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
	
	<div class="text-right"><a class="btn btn-warning" href="zuoyetijiaoAdd">上传作业</a></div>
		
	<br>
	
	<table class="table table-bordered table-hover">

	<tr>
		<th width="5%">ID</th>
		<th width="10%">作业名称</th>
	 
		<th width="10%">学生</th>
 
		<th width="10%">下载</th>
		<th width="10%">状态</th>
		
		<th width="10%">操作</th>
	</tr>
	
	<c:forEach var="zuoyetijiao" items="${zuoyetijiaoList}">
         <tr>
         	<td><p>${zuoyetijiao.id}</p></td>
         	<td><p>${zuoyetijiao.zuoyexxname}</p></td>
    
         	<td><p>${zuoyetijiao.teachername}</p></td>
 
         	<td><p><a class="btn btn-success" href="../../${zuoyetijiao.zyurl}">下载</a></p></td>
         	<td><p>${zuoyetijiao.zt}</p></td>
 
			<td>
			 	<c:if test="${zuoyetijiao.zt=='待批阅'}">
					<a class="btn btn-primary" href="zuoyetijiaoEdit?id=${zuoyetijiao.id}">修改</a>
					<a class="btn btn-danger" href="zuoyetijiaoDelete?id=${zuoyetijiao.id}" onclick="return confirm('确定删除吗?')" >删除</a>
				</c:if>

			</td>
       	</tr>
     </c:forEach>
     
</table>

<br>${pageTool}<br>
</div>
</body>
</html>