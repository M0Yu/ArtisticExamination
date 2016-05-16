<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新建常量</title>
    
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
  	<a href="constant/constant.jsp">返回</a>
  	<hr>
    <form action="addConstant.action" method="post">
		新建数据字段名： <input type="text" name="constant_name" />
		<br> 
		新建数据的数值： <input type="text" name="constant_value" />（*注意如数据类型不一致会造成错误）
		<br> 
		新建数据的描述： <input type="text" name="constant_desc" />
		<br> 
		<input type="submit" value="提交">
	</form>
  </body>
</html>
