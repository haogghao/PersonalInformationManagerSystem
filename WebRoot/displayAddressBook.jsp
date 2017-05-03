<%@ page language="java" import="java.util.*,com.dw.model.*"
	pageEncoding="utf-8"%>
<%@ page import="com.dw.dao.impl.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<style>
html{
margin-left: 20px;
}
</style>
<html >
	<head>
		<base href="<%=basePath%>">
		<title>显示用户信息</title>

     <style type="text/css">
       input[type="text"]{
              height: auto;
	          margin-bottom: 15px;
	          padding: 3px 9px;
            }
     </style>
	</head>

	<body>
<center>
        <form action="SearchByIdServlet?find=find_addressbook" method="post">
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                        通讯录---->姓名：<input type="text" name="searchName" value="" placeholder="学生学号...">
         <i class="icon-search"></i>&nbsp;<button type="submit" class="btn btn-inverse"> 查找</button>
        </form>
		<table  class="table table-hover table-condensed">
		    <tr>
				<td  align="center">
					<strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;通讯录id</strong>
				</td>
				
				<td align="center">
					<strong>姓名</strong>
				</td>
				<td align="center">
					<strong>联系方式</strong>
				</td>
				<td align="center">
					<strong>工作地点</strong>
				</td>
				<td align="center">
					<strong>城市</strong>
				</td>
				<td align="center">
					<strong>备注</strong>
				</td>
			</tr>
			<c:forEach items="${list}" var="person">
				<tr>
					<td>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${person.id}" />
					</td>
					<td>
						<c:out value="${person.name}" />
					</td>
					<td>
						<c:out value="${person.contact_way}" />
					</td>
					<td>
						<c:out value="${person.work_addr}" />
					</td>
					<td>
						<c:out value="${person.city}" />
					</td>
					<td>
						<c:out value="${person.beizhu}" />
					</td>

					<td>
						<a href="DeleteServlet?name=AddressBook&id=${person.id}" onclick="return del();" class="btn btn-danger">删除</a>
						<a href="UpdateServlet?updatetype=UpdateAddressBook&id=${person.id}" class="btn btn-primary">更新</a>
					</td>
				</tr>
			</c:forEach>
		</table>
</center>
		<hr>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="main.jsp" class="btn btn-success">返回主菜单</a>
		<a href="AddServlet?add=add_addressbook&id=${person.id}"" class="btn btn-success">添加通讯录</a>
		<hr>


	</body>
</html>
