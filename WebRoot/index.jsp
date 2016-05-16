<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>江汉大学播音主持招生考试Web系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    	欢迎使用江汉大学播音主持招生考试Web系统<br>
    	<hr>
    	<a href="inside/indexofinside.jsp">省内考试管理</a><br>
    	<a href="outside/indexofoutside.jsp">省外考试管理</a><br>
    	<a href="worker/indexofworker.jsp">工作人员管理</a><br>
    	<a href="uploadphotoes.jsp">考生照片上传</a><br>
    	<a href="questionbank/indexofquestion.jsp">题库管理</a><br>
    	<a href="constant/constant.jsp">管理常量表</a><br>
  </body>
</html>
