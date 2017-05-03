<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.dw.model.*,java.net.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>注册页</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery/jquery-1.5.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/login.js"></script>
<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
         function loadImage(){
	     document.getElementById("randImage").src = "${pageContext.request.contextPath}/image.jsp?"+Math.random(); //Math.random()方法非常重要，它使每次的请求都不同以便重新发送。如果每次的请求都一样，那么不会重新生成页面
         }
     function cancle(){
     window.self.location = "ShowUserServlet";
     }
      </script>
<style type="text/css">
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,form,fieldset,input,p,blockquote,th,td
	{
	margin: 0;
	padding: 0;
}

.form-signin {
	max-width: 500px;
	padding: 19px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 15px;
}

.form-signin input[type="text"],.form-signin input[type="password"] {
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}

h1 {
	color: #fff;
	background: #06b;
	padding: 10px;
	font-size: 200%;
	text-align: center;
}

.labelError {
	line-height: 9px;
	font-size: 10pt;
	color: #f40000;
	border: 1px #ffb8b8 solid;
	padding: 8px 8px 8px 35px;
	background: url(/StudentManagerWeb/images/error.png) no-repeat;
	background-color: #fef2f2;
}
</style>
</head>
<body>
	<div>
		<form class="form-signin" action="AddServlet?add=add_user" method="post">
			<h2 class="form-signin-heading">添加用户</h2>
			<hr>
			<table>
				<tr>
					<td></td>
					<td><font color="red">${error }</font>
					</td>
					<td></td>
				</tr>

				<tr>
					<td align="right">用户名：</td>
					<td><input type="text" name="username1" id="username1"
						class="input" value="">
					</td>
					<td><label class="labelError" id="usernameError"></label>
					</td>
				</tr>

				<tr>
					<td align="right">密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
					<td><input type="password" name="password1" id="password1"
						class="input" value="">
					</td>
					<td><label class="labelError" id="passwordError"></label>
					</td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td></td>
					<td><Input type="submit" value="添加" class="btn btn-primary"></Input>&nbsp;&nbsp;
						<Input type="Button" value="取消" onclick="cancle()" class="btn btn-primary"></Input>
					</td>
					<td></td>
				</tr>
				<tr>

				</tr>
			</table>
		</form>
	</div>
</body>
</html>