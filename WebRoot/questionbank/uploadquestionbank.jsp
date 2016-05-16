<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>上传题库</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <!--  <%=basePath%>Upload_QustionBank-->
  <body>
  	<a href="index.jsp">返回</a>
  	<hr>
    <form action="uploadQuesions.action" method="post" enctype="multipart/form-data">

		<input type="file" name = "questionBank">
	<!-- 	<input value="name" name="name" type="text" />  -->
		<input type="submit" value = "上传">
	</form>
  </body>
</html>
