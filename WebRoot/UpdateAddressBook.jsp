<%@ page language="java" import="java.util.*,com.dw.model.*" pageEncoding="utf-8"%>
<%@ page import="com.dw.dao.AddressBookDao"%>
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
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/update.js"></script>
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
		<form class="form-signin" action="UpdateSubmit?submittype=submitaddressbook" method="post" onSubmit="return checkstAge() && 
		checkstSex() && checkstTel() && checkstDept() && 
		checkstAddress() && checkstName()">
			编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：
			<input type="text" name="id1" value="${addressbook.id }"   class="input">
			<br>
			姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：
			<input class="input" type="text" name="name1" value="${addressbook.name }" 
			onblur="checkstName()" onFocus="clearstName()" >
			<span id="stName1"></span>
			<br>
			联系方式：
			<input class="input" type="text" name="contact_way1" value="${addressbook.contact_way }" onblur="checkstAge()" onFocus="clearstAge()" >
			<span id="stAge1"></span>
			<br>
			工作地点：
			<input class="input" type="text" name="work_addr1" value="${addressbook.work_addr }" onblur="checkstAge()" onFocus="clearstAge()" >
			<span id="stAge1"></span>
			<br>
			城&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;市：
			<input class="input" type="text" name="city1" value="${addressbook.city }" onblur="checkstTel()" onFocus="clearstTel()" >
			<span id="stTel1"></span>
			<br>
			备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：
			<input class="input" type="text" name="beizhu1" value="${addressbook.beizhu }" onblur="checkstDept()" onFocus="clearstDept()" >
			<span id="stDept1"></span>
			<br>
			
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<Button type="submit"  class="btn btn-primary">更新</Button>
			&nbsp;&nbsp;&nbsp;&nbsp;<Button type="button" class="btn btn-success" onclick="window.location.href='main.jsp'" >取消</Button>
		</form>
		</center>
	</body>
</html>
