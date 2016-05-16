<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加考生数据</title>
    
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
    <form action="addRegNum.action" method="post">
    	选择省份：
    	<select name="headNo">
    		<option value="">请选择</option>
    		<option value="138">河北省</option>
    		<option value="238">黑龙江省</option>
    		<option value="378">山东省</option>
    	</select>
    	<br>
    	输入起始号：
    	<input type="text" name="startNo"/>
    	<br>
    	输入终止号：
    	<input type="text" name="endNo"/>
    	<br>
    	<input type="submit" value="提交">
    </form>
  </body>
</html>
