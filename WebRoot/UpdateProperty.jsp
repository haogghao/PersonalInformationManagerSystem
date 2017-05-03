<%@ page language="java" import="java.util.*,com.dw.model.*" pageEncoding="utf-8"%>
<%@ page import="com.dw.dao.PropertyDao"%>
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

		<title>更新个人信息</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
		<form class="form-signin" action="UpdateSubmit?submittype=submitproperty" method="post" onSubmit="return checkstAge() && 
		checkstSex() && checkstTel() && checkstDept() && 
		checkstAddress() && checkstName()">
			编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：
			<input type="text" name="id1" value="${property.id }" readonly="readonly"  class="input">
			<br>
			总&nbsp;&nbsp;收&nbsp;&nbsp;入：
			<input class="input" type="text" name="income1" value="${property.income }" 
			onblur="checkstName()" onFocus="clearstName()" >
			<span id="stName1"></span>
			<br>
			
			消费工程：
			<input class="input" type="text" name="project1" value="${property.project }" onblur="checkstAge()" onFocus="clearstAge()" >
			<span id="stAge1"></span>
			<br>
			消费金额：
			<input class="input" type="text" name="money1" value="${property.money }" onblur="checkstTel()" onFocus="clearstTel()" >
			<span id="stTel1"></span>
			<br>
			消费时间：
			<input class="input" type="text" name="time1" value="${property.time }" onblur="checkstDept()" onFocus="clearstDept()" >
			<span id="stDept1"></span>
			<br>
			剩余金额：
			<input class="input" type="text" name="left_money1" value="${property.left_money }" onblur="checkstAddress()" onFocus="clearstAddress()" >
			<span id="stAddress1"></span>
			<br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<Button type="submit"  class="btn btn-primary">更新</Button>
			&nbsp;&nbsp;&nbsp;&nbsp;<Button type="button" class="btn btn-success" onclick="window.location.href='main.jsp'"  >取消</Button>
		</form>
		</center>
	</body>
</html>
