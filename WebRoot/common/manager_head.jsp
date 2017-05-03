<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<style>
.nav ul {
 list-style-type: none;
 margin:0px;
 padding:0px;
}
.nav li {
 margin:7px;
 padding:5px;
 float:left;
 height:40px;
}
.headLeft {
margin-left: 20px;
}
.headRight{
margin-left: 20px;
}
</style>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>个人信息管理系统主界面</title>
	</head>

	<body>
		<div class="row-fluid">
			<div class="span12">
				<div class="head" style="margin-top:30px">
					<div class="headLeft">
						<!-- <img src="${pageContext.request.contextPath}/images/logo.png" /> -->
						<div style="font-size:40px;color:blue";>个人信息管理系统</div>
					</div><br/>
					<div class="headRight">
						欢迎管理员：
						<font color="red"><%=session.getAttribute("username")%></font>&nbsp;&nbsp;&nbsp;
						 <i class="icon-time"></i>&nbsp;&nbsp;<font id="today"></font>
						 <font style="float: right;margin-right: 40px;"><a href="logout.jsp" onclick="return check();">退出系统</a></font>
					</div>
				</div>
			</div>
		</div> 

	</body>
</html>
