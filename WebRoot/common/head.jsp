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
						<div style="font-size:40px;color:blue;margin-left: 40px">个人信息管理系统</div>
					</div><br/>
					<div class="headRight" style="margin-left: 40px">
						欢迎用户：
						<font color="red"><%=session.getAttribute("username")%></font>&nbsp;&nbsp;&nbsp;
						 <i class="icon-time"></i>&nbsp;&nbsp;<font id="today"></font>
					</div>
				</div>
			</div>
		</div> 
		<div class="row-fluid" >
			<div class="span12">
				<div class="navbar">
					<div class="navbar-inner">
					   <a class="brand" href="main.jsp"><i class="icon-home"></i>&nbsp;首页</a>
						<ul class="nav">
							<li><a href="AddressBookServlet"><i class="icon-pencil"></i>&nbsp;通讯录 </a></li>
						    <li><a href="MemoServlet"><i class="icon-book"></i>&nbsp;备忘录 </a></li>
						    <li><a href="DiaryServlet"><i class="icon-pencil"></i>&nbsp;日记 </a></li>
						    <li><a href="PropertyServlet"><i class="icon-pencil"></i>&nbsp;财物 </a></li>
							<li><a href="UpdateServlet?updatetype=UpdatePassWord"><i class=" icon-cog"></i>&nbsp;修改密码</a></li>
							<li><a href="logout.jsp" onclick="return check();"><i class="icon-user"></i>&nbsp;退出系统</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
