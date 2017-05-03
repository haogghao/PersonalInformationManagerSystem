<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<style>
li{
margin-bottom: 30px;
margin-left: 10px;
}
</style>
<div>
<%--空心圆显示 --%>
<ul type="circle" style="font-size: 30px">  
<li ><a href="AddressBookServlet?action=find">通讯录信息</a></li> 
<li ><a href="MemoServlet">备忘录信息</a></li>
<li ><a href="DiaryServlet">日记信息</a></li>  
<li ><a href="PropertyServlet">个人财物管理</a></li>  
</ul> 
</div>