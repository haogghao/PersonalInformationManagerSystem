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

        <form action="SearchByIdServlet?find=find_property" method="post">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                       财务---->消费项目：<input type="text" name="searchProject" placeholder="学生学号...">
         <i class="icon-search"></i>&nbsp;<button type="submit" class="btn btn-inverse"> 查找</button>
        </form>
		<table  class="table table-hover table-condensed">
		    <tr>
				<td align="center">
					<strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;财务id</strong>
				</td>
				
				<td align="center">
					<strong>消费项目</strong>
				</td>
				<td align="center">
					<strong>总收入</strong>
				</td>
				<td align="center">
					<strong>消费金额</strong>
				</td>
				<td align="center">
					<strong>消费时间</strong>
				</td>
				<td align="center">
					<strong>剩余资金</strong>
				</td>
			</tr>
			<c:forEach items="${list}" var="person">
				<tr>
					<td>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${person.id}" />
					</td>
					
					<td>
						<c:out value="${person.project}" />
					</td>
					<td>
						<c:out value="${person.income}" />
					</td>
					<td>
						<c:out value="${person.money}" />
					</td>
					<td>
						<c:out value="${person.time}" />
					</td>
										<td>
						<c:out value="${person.left_money}" />
					</td>
					<td>
						<a href="DeleteServlet?name=Property&id=${person.id}" onclick="return del();" class="btn btn-danger">删除</a>
						<a href="UpdateServlet?updatetype=UpdateProperty&id=${person.id}" class="btn btn-primary">更新</a>
					</td>
				</tr>
			</c:forEach>
		</table>

		<hr>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="main.jsp" class="btn btn-success">返回主菜单</a>
		<a href="AddServlet?add=add_property&id=${person.id}"" class="btn btn-success">添加财物信息</a>
		<hr>


	</body>
</html>
