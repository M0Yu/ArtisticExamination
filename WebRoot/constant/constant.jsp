<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理常量表</title>
    
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
  	<a href="index.jsp">返回</a>
  	<hr>
  	<a href="constant/addconstant.jsp">新建常量</a>
    <br>
    <a href="constant/updateconstant.jsp">修改常量</a>
    <br>
    <a href="constant/deleteconstant.jsp">删除常量</a>
    <br>
    <a href="constant/checkconstant.jsp">查看所有常量</a>
    <br>
  </body>
</html>
