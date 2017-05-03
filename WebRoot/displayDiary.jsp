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
<html>
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

        <form action="SearchByIdServlet?find=find_diary" method="post">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                        日记---->事件：<input type="text" name="searchEvent" placeholder="学生学号...">
         <i class="icon-search"></i>&nbsp;<button type="submit" class="btn btn-inverse"> 查找</button>
        </form>
		<table  class="table table-hover table-condensed">
		    <tr>
				<td align="center">
					<strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日记id</strong>
				</td>
					<td align="center">
					<strong>事件</strong>
				</td>
				<td align="center">
					<strong>时间</strong>
				</td>				
				<td align="center">
					<strong>地点</strong>
				</td>
			
				<td align="center">
					<strong>人物</strong>
				</td>
			</tr>
			<c:forEach items="${list}" var="person">
				<tr>
					<td>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${person.id}" />
					</td>
					<td>
						<c:out value="${person.event}" />
					</td>
					<td>
						<c:out value="${person.time}" />
					</td>
					<td>
						<c:out value="${person.addr}" />
					</td>
			
					<td>
						<c:out value="${person.characters}" />
					</td>

					<td>
						<a href="DeleteServlet?name=Diary&id=${person.id}" onclick="return del();" class="btn btn-danger">删除</a>
						<a href="UpdateServlet?updatetype=UpdateDiary&id=${person.id}" class="btn btn-primary">更新</a>
					</td>
				</tr>
			</c:forEach>
		</table>

		<hr>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="main.jsp" class="btn btn-success">返回主菜单</a>
		<a href="AddServlet?add=add_diary&id=${person.id}"" class="btn btn-success">添&nbsp;加&nbsp;日&nbsp;记</a>
		<hr>


	</body>
</html>
