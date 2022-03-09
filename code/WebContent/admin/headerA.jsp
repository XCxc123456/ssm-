<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <style type="text/css">
		    body {
			margin-left: 0px;
			margin-top: 0px;
			margin-right: 0px;
			margin-bottom: 0px;
			background-color:#19A97B;
		}
		.STYLE1 {
			font-size: 12px;
			border-width:33px;
			color: ;
		}
		.STYLE5 {font-size: 12}
		.STYLE7 {font-size: 12px; color: #FFFFFF; }
    </style>
		<script language="javascript">
			function calender()
			{
				 var time=new Date();
				 var year=time.getYear();
				 var month=time.getMonth()+1;
				 var day=time.getDate();
				 var hour=time.getHours();
				 var minute=time.getMinutes();
				 var second=time.getSeconds();
				 if(minute<10)
				 {
				  minute="0"+minute;
				 }
				 if(second<10)
				 {
				  second="0"+second;
				 }
				 document.myform.date.value=year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
				 var mytime=setTimeout("calender()",1000);
			}
			</script>
  </head>
  
  <body onLoad="calender()">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="80" background="<%=path %>/images/1c.gif">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td style="FONT-WEIGHT: bold; FONT-SIZE: 23pt; FILTER: Glow(Color=#00347F,Strength=4); WIDTH: 100%; COLOR: #ffffff; font-family: 黑体">
							     &nbsp;&nbsp;&nbsp;&nbsp;基于Web作业管理系统
							</td>
							<td width="281" valign="bottom">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="33" height="27">
											
										</td>
										<td width="248">
											<table width="225" border="0" align="center" cellpadding="0"
												cellspacing="0">
												<tr>
													<td height="17">
														<div align="right">
														 	<font style="font-size: 12px;font-weight: bold">
														 	<% 
														 		String username= session.getAttribute("username").toString();
														 		String zyurl= session.getAttribute("zyurl").toString();
														 		String mname= session.getAttribute("mname").toString();
														 	%>
															    当前登录用户： <%=username %> [ <%=zyurl %> ]
															    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															</font>
														</div>
													</td>
													<td>
														<div align="right">
															 
														</div>
													</td>
													<td>&nbsp;
														
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			 
		 
		</table>
	</body>
</html>
