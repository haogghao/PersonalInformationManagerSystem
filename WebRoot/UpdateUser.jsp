<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>更新学生信息</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/stupdate.js"></script>
	<style type="text/css">
	  span{color:red;}
	  .form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 10px;
}
.form-signin input[type="text"],.form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}
.form-signin {
	max-width: 550px;
	padding: 19px 29px 29px;
	margin:0 auto;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}
	</style>

	</head>
	<body>
		<center>
		<form class="form-signin" action="UpdateSubmit?submittype=submituser" method="post" onSubmit="return checkstAge() && 
		checkstSex() && checkstTel() && checkstDept() && 
		checkstAddress() && checkstName()">
			编&nbsp;&nbsp;&nbsp;&nbsp;号：
			<input type="text" name="userid2" value="${userObject.userid }" readonly="readonly"  class="input">
			<br>
			用户名：
			<input type="text" name="username2" value="${userObject.username }" class="input">
			<br>
			密&nbsp;&nbsp;&nbsp;&nbsp;码：
			<input class="input" type="text" name="password2" value="${userObject.password }" 
			onblur="checkstName()" onFocus="clearstName()" >
			<span id="stName1"></span>
			<br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit"  value="提交" class="btn btn-primary">&nbsp;&nbsp;&nbsp;
			<input type="button"  class="btn btn-success" onclick="window.location.href='ShowUserServlet'"  value="返回"> 
		</form>
		</center>
	</body>
</html>
