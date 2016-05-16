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

<title>查看考官评分</title>

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
	<a href="outside/indexofoutside.jsp">返回</a>
  	<hr>

	<%
		WorkersDAO dao = new WorkersDAO();
		List<Workers> workers = dao.findAll();
	%>
	
	<form action="outside/showmarks.jsp" method="post">
		选择考官： <select name="WorkerName">
			<%
				for (Workers worker : workers) {
					if (worker.getIdenType().equals("考官")) {
						out.println("<option value=\"" + worker.getName() + "\">"
								+ worker.getName());
						out.println("</option>");
					}
				}
			%>
		</select> 
		<input type="submit" value="查询" />
	</form>
</body>
</html>
