<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<title></title>
<script type="text/javascript">

	function addItem() {
		window.self.location = "adduser.jsp";
	}
	
	function modifyItem() {
		var count = 0;
		var j = 0;
		for (var i = 0; i < document.getElementsByName("selectFlag").length; i++) {
			if (document.getElementsByName("selectFlag")[i].checked) {
				j = i;
				count++;
			}
		}
		if (count == 0) {
			alert("请选择需要修改的用户！");
			return;
		}
		if (count > 1) {
			alert("一次只能修改一个用户！");
			return;
		}
		if (count == 1) {
			window.self.location = "UpdateServlet?updatetype=UpdateUser&user_id=" + 
			                        document.getElementsByName("selectFlag")[j].value;
		}
	}
	
	function deleteItem() {
	 
		var flag = false;
		for (var i = 0; i < document.getElementsByName("selectFlag").length; i++) {
			if (document.getElementsByName("selectFlag")[i].checked) {
				flag = true;

			}		
		}
		
		if (!flag) {
			alert("请选择需要删除的用户！");
			return;
		}
		if (window.confirm("确认删除吗？")) {
			with (document.getElementById("userForm")) {
			
				method = "post";
				
				action = "DeleteServlet?name=User&use_id=id";
				submit();
			}
		}
	}
	
	function checkAll() {
		for (var i = 0; i < document.getElementsByName("selectFlag").length; i++) {
			document.getElementsByName("selectFlag")[i].checked = document.getElementById("ifAll").checked;
		}
	}
	
	function queryItem() {
		with (document.getElementById("userForm")) {
			method = "post";
			action = "SearchByIdServlet?find=find_user";
			submit();
		}
	}
	
	function myOnkeypress() {
		if (window.event.keyCode == 13) {
			queryItem();
		}
	}
	

	</script>
</head>

<body>
	<TABLE cellSpacing="1" cellPadding="2" width="60%" align="center"
		border="0">
		<TR>
			<TD width="522" class="p1" height="2" nowrap>
				<b>用户管理</B>
			</TD>
		</TR>
	</TABLE>

	<hr width="60%">
	<Form name="userForm" id="userForm">
		<TABLE class=small cellSpacing="1" cellPadding="2" width="60%"
			align="center" border="0">
			<TR>
				<TD align=center><font>用户名:</font>&nbsp;&nbsp;<input
					type="text" name="username" id="username" class="BigInput"
					onkeypress="myOnkeypress()" size="40" maxlength="40"></Input>
					<Button name="btnQuery" type="button" class="BigButton"
						id="btnQuery" onClick="queryItem()">查询</Button>
					<Button name="btnReset" type="reset" class="BigButton"
						id="btnReset" >重置</Button></TD>
			</TR>
		</TABLE>

		<TABLE class=small cellSpacing="1" cellPadding="2" width="60%"
			align="center" border="0">
			<TR>
				<TD  width="5%" align="center"><input
					type="checkbox" name="ifAll" onClick="checkAll()">
				</TD>
				<TD  width="25%" align="center"><strong>用户名</strong>
				</TD>
				
				<TD  width="25%" align="center"><strong>密码</strong>
				</TD>
				<TD  width="25%" align="center"><strong>用户类型</strong>
				</TD>
			</TR>

			<c:forEach items="${userlist}" var="item">
				<tr>
					<td width="5%" align="center"><input type="checkbox" name="selectFlag"
						id="selectFlag" class="checkbox1" value="${item.userid }"></input
					</td>
					<td width="25%" align="center"><c:out value="${item.username}" /></td>
					<td width="25%" align="center"><c:out value="${item.password}" /></td>
					<td width="25%" align="center"><c:out value="个人" /></td>
				</tr>				
			</c:forEach>
		</TABLE>

		<div align="center" style="margin-right:100px;float: right">
			<Button name="btnAdd" class="BigButton" id="btnAdd" value="添加"
				onClick="addItem()">添加</Button>
			<Button name="btnDelete" type="button" class="BigButton"
				id="btnDelete" value="删除" onClick="deleteItem()">删除</Button>
			<Button name="btnModify" type="button" class="BigButton"
				id="btnModify" value="修改" onClick="modifyItem()">修改</Button>
		</div>
	</Form>
</body>
</html>
