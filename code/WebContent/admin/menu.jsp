<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="css/bootstrap.css" />
		<style type="text/css">
			<!--
			body {
				margin-left: 0px;
				margin-top: 0px;
				margin-right: 0px;
				margin-bottom: 0px;
				background-color:#222D32;
			}
			.STYLE3 {
				font-size: 12px;
				color: #435255;
			}
			.STYLE4 {font-size: 12px}
			.STYLE5 {font-size: 16px; font-weight: bold; }
			a:link {font-size:12px; text-decoration:none; color:#FFFFFF;}
			a:visited {font-size:12px; text-decoration:none; color:#FFFFFF;}
			a:hover{font-size:12px; text-decoration:none; color:#FFFFFF;}
			-->
		</style>
</head>
<body >
<div class="wrapper">
 <div class="sidebar">
<% 
	String username= session.getAttribute("username").toString();
	String zyurl= session.getAttribute("zyurl").toString();
	String id= session.getAttribute("uid").toString();
	String mname= session.getAttribute("mname").toString();
	
%>


<% 
	if(zyurl.equals("管理员"))
	{
%>												 	
        <div class="sidebar-wrapper">
            <!--左侧导航-->
            <ul class="nav">
               <li id="4"  class="nav-item">
                    <a href="adminRe" target='main'>
                        <i class="la la-bell"></i>
                        <p>修改密码</p>
                        <!--<span class="badge badge-success">3</span>-->
                    </a>
                </li>
                <li id="3"  class="nav-item">
                    <a href="typeList" target='main'>
                        <i class="la la-th"></i>
                        <p>课程管理</p>
                        <!--<span class="badge badge-count">6</span>-->
                    </a>
                </li>

                <li id="5"  class="nav-item">
                    <a href="teacher/teacherList" target='main'>
                        <i class="la la-font"></i>
                        <p>老师管理</p>
                        <span id="diaryLen" class="badge badge-danger"></span>
                    </a>
                </li>
                <li id="2"  class="nav-item active">
                    <a href="userList" target='main'>
                        <i class="la la-keyboard-o"></i>
                        <p>学生管理</p>
                        <!--<span class="badge badge-count">50</span>-->
                    </a>
                </li>
 
                <li id="5"  class="nav-item">
                    <a href="news/newsList" target='main'>
                        <i class="la la-font"></i>
                        <p>公告管理</p>
                        <span id="diaryLen" class="badge badge-danger"></span>
                    </a>
                </li>
                

                
                <li id="5"  class="nav-item">
                    <a href="logout"  target="_top">
                        <i class="la la-font"></i>
                        <p>退出</p>
                        <span id="diaryLen" class="badge badge-danger"></span>
                    </a>
                </li>
            </ul>
        </div>
<% 
	}
	if(zyurl.equals("老师"))
	{
%>	
        <div class="sidebar-wrapper">
            <!--左侧导航-->
            <ul class="nav">
                <li class="nav-item">
                    <a href="teacher/teacherEdi1t?id=<%=id %>" target='main'>
                        <i class="la la-dashboard"></i>
                        <p>修改信息</p>
                        <!--<span class="badge badge-count">5</span>-->
                    </a>
                </li>
 
                <li id="5"  class="nav-item">
                    <a href="kaoshixx/kaoshixxList" target='main'>
                        <i class="la la-font"></i>
                        <p>考试管理</p>
                        <span id="diaryLen" class="badge badge-danger"></span>
                    </a>
                </li>
                
               <li id="2"  class="nav-item active">
                    <a href="zuoyexxList2?mname=<%=mname %>" target='main'>
                        <i class="la la-keyboard-o"></i>
                        <p>作业管理</p>
                        <!--<span class="badge badge-count">50</span>-->
                    </a>
                </li>

                <li id="5"  class="nav-item">
                    <a href="zuoyetijiao/zuoyetijiaoList1" target='main'>
                        <i class="la la-font"></i>
                        <p>作业批阅</p>
                        <span id="diaryLen" class="badge badge-danger"></span>
                    </a>
                </li>
                
              <li id="5"  class="nav-item">
                    <a href="news/newsListQ" target='main'>
                        <i class="la la-font"></i>
                        <p>公告查看</p>
                        <span id="diaryLen" class="badge badge-danger"></span>
                    </a>
                </li>
                
                <li id="5"  class="nav-item">
                     <a href="logout"  target="_top">
                        <i class="la la-font"></i>
                        <p>退出</p>
                        <span id="diaryLen" class="badge badge-danger"></span>
                    </a>
                </li>
            </ul>
        </div>
<% 
	}
	if(zyurl.equals("学生"))
	{
%>	
        <div class="sidebar-wrapper">
            <!--左侧导航-->
            <ul class="nav">
                <li class="nav-item">
                    <a href="userEdit1?id=<%=id %>" target='main'>
                        <i class="la la-dashboard"></i>
                        <p>修改信息</p>
                        <!--<span class="badge badge-count">5</span>-->
                    </a>
                </li>
 
                <li id="2"  class="nav-item active">
                    <a href="zuoyexxList1" target='main'>
                        <i class="la la-keyboard-o"></i>
                        <p>作业查看</p>
                        <!--<span class="badge badge-count">50</span>-->
                    </a>
                </li>
                
                <li id="5"  class="nav-item">
                    <a href="zuoyetijiao/zuoyetijiaoList" target='main'>
                        <i class="la la-font"></i>
                        <p>提交作业</p>
                        <span id="diaryLen" class="badge badge-danger"></span>
                    </a>
                </li>
                
                <li id="5"  class="nav-item">
                    <a href="kaoshixx/kaoshixxListQ" target='main'>
                        <i class="la la-font"></i>
                        <p>考试信息</p>
                        <span id="diaryLen" class="badge badge-danger"></span>
                    </a>
                </li>

                
              <li id="5"  class="nav-item">
                    <a href="news/newsListQ" target='main'>
                        <i class="la la-font"></i>
                        <p>公告查看</p>
                        <span id="diaryLen" class="badge badge-danger"></span>
                    </a>
                </li>
                
                <li id="5"  class="nav-item">
                     <a href="logout"  target="_top">
                        <i class="la la-font"></i>
                        <p>退出</p>
                        <span id="diaryLen" class="badge badge-danger"></span>
                    </a>
                </li>
            </ul>
        </div>
<% 
	}
%>	
    </div>
  </div>
</body>
</html>