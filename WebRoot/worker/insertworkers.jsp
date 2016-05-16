<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html"%>
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

<title>添加工作人员</title>

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
	<a href="worker/indexofworker.jsp">返回</a>
  	<hr>
  	
	<form action="<%=basePath%>insertWorker.action" method="post">
		请选择工作人员的职务： <select name="IdenType">
			<option value="无">请选择</option>
			<option value="考官">考官</option>
			<option value="检录员">检录员</option>
			<option value="体测员">体测员</option>
			<option value="抽题员">抽题员</option>
		</select><br> <br> 请输入工作人员的姓名： <input name="Name" type="text"
			style="height: 20px; "><br> （*姓名为工作人员登录的唯一标识，请确保无输入错别字）
		<br> <br> 请选择工作人员的负责考场： <select name="QusType">
			<option value="">请选择</option>
			<option value="1">第一考场</option>
			<option value="2">第二考场</option>
			<option value="3">第三考场</option>
		</select><br> （*非考官职务的人员输入此数据无用） <br> <input type="submit" value="提交">
	</form>
</body>
</html>
