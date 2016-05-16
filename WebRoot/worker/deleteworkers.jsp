<%@page import="com.artistic_exam.Workers.Workers"%>
<%@page import="com.artistic_exam.Workers.WorkersDAO"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>删除工作人员</title>

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
  	
	<%
		WorkersDAO dao = new WorkersDAO();
		@SuppressWarnings("unchecked")
		List<Workers> workers = dao.findAll();
	%>
	
	<form action="deleteWorker.action" method="post">
		选择工作人员： <select name="Name">
			<%
				for (Workers worker : workers) {
					out.print("<option value=\"" + worker.getName() + "\">"
							+ worker.getName());
					out.print("</option>");

				}
			%>
			<option value="all" selected="selected">删除全部</option>
		</select> 
		<br>
		<input type="submit" value="删除" />
	</form>
</body>
</html>
