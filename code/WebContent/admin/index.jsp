<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>基于Web作业管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <style>
	body
	{
	  scrollbar-base-color:#00A4FF;
	  scrollbar-arrow-color:#00A4FF;
	  scrollbar-shadow-color:#00A4FF;
	}
	</style>
  </head>
  <frameset rows="90,*" cols="*" frameborder="no" border="0" framespacing="0">
	  <frame src="<%=path %>/admin/headerA.jsp" name="topFrame" scrolling="no">
	  <frameset cols="180,*" name="btFrame" frameborder="NO" border="0" framespacing="0">
	    <frame src="<%=path %>/admin/menu.jsp" noresize name="menu" scrolling="no">
	    <frame src="<%=path %>/admin/system.jsp" noresize name="main" scrolling="yes">
	  </frameset>
  </frameset>
  <noframes>
	  <body>您的浏览器不支持框架！</body>
  </noframes>
</html>
