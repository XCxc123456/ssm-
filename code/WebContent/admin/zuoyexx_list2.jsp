<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>作业列表</title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="css/bootstrap.css"/> 
</head>
<body>
<div class="container-fluid">

	<%@include file="header.jsp" %>
	
	<div class="text-right"><a class="btn btn-warning" href="zuoyexxAdd">添加作业</a></div>
	
	<br>
		
	<ul role="tablist" class="nav nav-tabs">
        <li <c:if test='${status==0}'>class="active"</c:if> role="presentation">全部作业</li>
      
    </ul>
    
    <c:if test="${status == 1}"><br><p>首页默认只显示前[1]条记录</p></c:if>
    <c:if test="${status == 2}"><br><p>首页默认只显示前[6]条记录</p></c:if>
    <c:if test="${status == 3}"><br><p>首页默认只显示前[8]条记录</p></c:if>
	
	<br>

	<table class="table table-bordered table-hover">

	<tr>
		<th width="5%">ID</th>
		<th width="10%">图片</th>
		<th width="10%">名称</th>
		<th width="10%">人数</th>
 
		<th width="10%">课程</th>
		<th width="10%">老师</th>
		
		<th width="10%">下载</th>
		
		<th width="20%">操作</th>
	</tr>
	
	<c:forEach var="zuoyexx" items="${zuoyexxList}">
         <tr>
         	<td><p>${zuoyexx.id}</p></td>
         	<td><p><img src="../${zuoyexx.image1}" width="100px" height="100px"></a></p></td>
         	<td><p>${zuoyexx.name}</a></p></td>
         	<td><p>${zuoyexx.renshu}</p></td>
         	<td><p>${zuoyexx.type.name}</p></td>
         	<td><p>${zuoyexx.teachername}</p></td>
         	<td><p><a class="btn btn-success" href="../${zuoyexx.cover}">下载</a></p></td>
			<td>
 
				<a class="btn btn-success" href="zuoyexxEdit?id=${zuoyexx.id}">修改</a>
				<a class="btn btn-danger" href="zuoyexxDelete?id=${zuoyexx.id}" onclick="return confirm('确定删除吗?')" >删除</a>
			</td>
       	</tr>
     </c:forEach>
     
</table>

<br>${pageTool}<br>
</div>


<script type="text/javascript" src="js/jquery.js"></script>
<!-- 
<script type="text/javascript">
$(function(){
	$(document).on("click", ".topSave", function(){
		var type = $(this).attr("type");
		var zuoyexxid = $(this).attr("zuoyexxid");
		var text = $(this).attr("text");
		var old = $(this).text();
		var obj = this;
		$.post("topSave.action", {"zuoyexxId": zuoyexxid, "type": type}, function(data){
			if(data=="ok"){
				$(obj).text(text).attr("class", "btn btn-info topDelete").attr("text", old);
			}else{
				alert("操作失败!");
			}
		}, "text");
	});
	$(document).on("click", ".topDelete", function(){
		var type = $(this).attr("type");
		var zuoyexxid = $(this).attr("zuoyexxid");
		var text = $(this).attr("text");
		var old = $(this).text();
		var obj = this;
		$.post("topDelete.action", {"zuoyexxId": zuoyexxid, "type": type}, function(data){
			if(data=="ok"){
				$(obj).text(text).attr("class", "btn btn-primary topSave").attr("text", old);
			}else{
				alert("操作失败!");
			}
		}, "text");
	});
});
</script>
 -->
</body>
</html>